define(function(require, exports, module) {
	//表单验证
	require('validate');
	require('validate.extend');
	//异步提交
	require('form')();
	//弹窗
	require('Y-window');
	//弹窗提示
	var hintPopup = require('zyw/hintPopup');
	//验证方法集
	require('zyw/project/bfcg.itn.addValidataCommon');
	var template = require('arttemplate');
	//页面提交后跳转处理
	var showResult = require('zyw/process.result');
	//项目编号
	var searchForDetails = require('zyw/searchForDetails');
	var getList = require('zyw/getList');

	var util = require('util'),
		loading = new util.loading();

	//------ 选择项目 start
	var _getList = new getList();
	_getList.init({
		title: '项目列表',
		ajaxUrl: '/baseDataLoad/queryProjects.json?phases=INVESTIGATING_PHASES&phasesStatus=WAITING&status=NORMAL&isAdd=YES',
		btn: '#choose',
		tpl: {
			tbody: ['{{each pageList as item i}}',
				'    <tr class="fn-tac m-table-overflow">',
				'        <td class="item onbreak" id="{{item.name}}">{{item.projectCode}}</td>',
				'        <td class="onbreak" title="{{item.projectName}}">{{(item.projectName && item.projectName.length > 6)?item.projectName.substr(0,6):item.projectName}}</td>',
				'        <td class="onbreak" title="{{item.customerName}}">{{(item.customerName && item.customerName.length > 6)?item.customerName.substr(0,6):item.customerName}}</td>',
				'        <td class="onbreak">{{item.busiTypeName}}</td>',
				'        <td class="onbreak">{{item.amount}}</td>',
				'        <td class="onbreak"><a class="choose" projectNumber="{{item.projectCode}}" href="javascript:void(0);">选择</a></td>',
				'    </tr>',
				'{{/each}}'
			].join(''),
			form: ['项目名称：',
				'<input class="ui-text fn-w160" name="projectName" type="text">',
				'&nbsp;&nbsp;',
				'客户名称：',
				'<input class="ui-text fn-w160" name="customerName" type="text">',
				'&nbsp;&nbsp;',
				'<input class="ui-btn ui-btn-fill ui-btn-green" type="submit" value="筛选">'
			].join(''),
			thead: ['<th width="100">项目编号</th>',
				'<th width="120">项目名称</th>',
				'<th width="120">客户名称</th>',
				'<th width="100">授信类型</th>',
				'<th width="100">授信金额（元）</th>',
				'<th width="50">操作</th>'
			].join(''),
			item: 6
		},
		callback: function($a) {
			window.location.href = '/projectMg/investigation/addDeclare.htm?projectCode=' + $a.attr('projectNumber') + "&declares=" + $('input[name=declares').val()
		}
	});

	//返回链接
    var ONLY_VALUE = 0
    $('#saveSubmit').click(function () {
        ONLY_VALUE = 1;
    })

	//现场调查人员弹窗
	var scope = "{type:\"system\",value:\"all\"}";
	var selectUsers = {
		selectUserIds: "",
		selectUserNames: ""
	}
	var BPMiframe = require('BPMiframe'); //isSingle=true 表示单选
	var singleSelectUserDialog = new BPMiframe('/bornbpm/platform/system/sysUser/dialog.do', {
		'title': '单选用户',
		'width': 850,
		'height': 460,
		'scope': scope,
		'selectUsers': selectUsers,
		'bpmIsloginUrl': '/bornbpm/bornsso/islogin.do?userName=' + $('#hddUserName').val(),
		'makeLoginUrl': '/JumpTrust/makeLoginUrl.htm'
	});

	// window.frameElement.dialog=singleSelectUserDialog;
	$('body').on('click', '.peopleBtn', function() {

		var $this = $(this);

		singleSelectUserDialog.init(function(relObj) {

			for (var i = 0; i < relObj.userIds.length; i++) {
				$this.siblings('.peopleID').val(relObj.userIds);
				$this.siblings('.people').val(relObj.fullnames);
			}

		});

	});

	var _investigateId = $('input[name="investigateId"]').val();
	var _show = $('input[name="show"]').val();
	if ((isNaN(_investigateId) || _investigateId <= 0) && _show != 'NO') {

		$('body').Y('Window', {
			content: $('#newPopupScript').html(),
			modal: true,
			key: 'modalwnd',
			simple: true
		});
		var modalwnd = Y.getCmp('modalwnd'),
			callbacks = $.Callbacks();

		//计时
		reciprocalSet = {
			obj: modalwnd.wnd,
			max: 5,
			min: 0,
			stopAddFucn_f: function() {
				reciprocalSet.obj.find('input').each(function(index, el) {
					$(el).attr('disabled', false);
				});
			}
		}
		reciprocal = {
			auto_f: function() {
				reciprocal.before_f();
				time = setInterval(function() {
					var _variation = reciprocal.fucn_f();
					reciprocalSet.obj.find('a em').text('(' + _variation + ')');
					if (_variation < reciprocalSet.min) {
						reciprocalSet.obj.find('a').text('请勾选申明条款');
						reciprocal.callbacks_f();
					}
				}, 1000)
			},
			stop_f: function() {
				clearInterval(time);
			},
			fucn_f: function() {
				reciprocalSet.max -= 1;
				return reciprocalSet.max;
			},
			before_f: function() {
				reciprocalSet.obj.find('input').each(function(index, el) {
					$(el).attr('disabled', true);
				});
				reciprocalSet.obj.find('a em').text('(' + reciprocalSet.max + ')');
			},
			callbacks_f: function() {
				callbacks.add(reciprocal.stop_f());
				callbacks.add(reciprocalSet.stopAddFucn_f());
			}
		}
		reciprocal.auto_f();


		//是否同意完申明
		
		$('input[type="radio"]').change(function(event) {

			var _this = $(this),
				_parents = _this.parents('ul'),
				_checked = _parents.find('input[type="radio"]:checked'),
				_length = _checked.length,
				_judge = (_parents.find('.li').length == _length),
				_YX = '';
			
			_judge ? modalwnd.wnd.find('.close').on('click', function() {
				_checked.each(function(index, el) {
					_YX += $(el).val();
				});
				$('input[name="declares"]').val(_YX);
				modalwnd.close();
			}).removeClass('ui-btn-gray').addClass('ui-btn-green').text('确定') : modalwnd.wnd.find('.close').off('click');

		});
	}


	//验证
	var save_form = $('#form'),
		fm5, checkStatus, toIndex;
	if (save_form.length) {
		save_form.validate({
			errorClass: 'error-tip',
			errorElement: 'b',
			errorPlacement: function(error, element) {
				element.after(error);
			},
			onkeyup: false, //不在按键时进行验证
			ignore: '.cancel',
			submitHandler: function(form) {
				loading.open();
				$(form).ajaxSubmit({
					type: 'post',
					dataType: 'json',
					data: {
						fm5: fm5,
						checkStatus: checkStatus,
						toIndex: toIndex
					},
					success: function(res) {
                        if(ONLY_VALUE === 1){
                            showResult(res, hintPopup(res.message,$("#backUrl").attr('data-url')));
                            window.location.href = $("#backUrl").attr('data-url')
                        } else {
                            showResult(res, hintPopup);
                        }
					}
				});
			},
			rules: {
				projectCodeShow: {
					required: true
				}
			},
			messages: {
				projectCodeShow: {
					required: '必填'
				}
			}
		});
	}

	//必填集合
	require('zyw/requiredRules');
	var _allWhetherNull = 'investigatePlace,investigateDateStr,investigatePersion,receptionPersion,netAsset,receptionDuty',
		requiredRules = save_form.requiredRulesSharp(_allWhetherNull, false, {}, function(rules, name) {
			rules[name] = {
				required: true,
				messages: {
					required: '必填'
				}
			};
		}),
		maxLengthRules = {
			receptionPersion: {
				maxlength: 500,
				messages: {
					maxlength: '已超出500字'
				}
			},
			investigatePlace: {
				maxlength: 100,
				messages: {
					maxlength: '已超出100字'
				}
			}
		},
		rulesAll = $.extend(true, requiredRules, maxLengthRules);


	//验证方法集初始化
	$('.fnAddLine').addValidataCommon(rulesAll, true)
		.initAllOrderValidata()
		.assignGroupAddValidataUpUp();

	var md5 = require('md5'); //md5加密
	function formSerializeMd5(_form) {
		var _formSerialize = _form.serialize();
		return md5(_formSerialize);
	}

	function fm5WhetherChange() {
		var _newSerializeMd5 = formSerializeMd5(save_form);
		fm5 = (_newSerializeMd5 != _initSerializeMd5) ? 1 : 0; //数据是否有改变
	}

	function rulesAllFalse() {
		$.fn.whetherMust(rulesAll, false).allAddValidata(rulesAll); //否必填
		checkStatus = save_form.allWhetherNull(_allWhetherNull, false); //是否填写完整
	}

	var _initSerializeMd5 = formSerializeMd5(save_form); //初始页面数据

	$('#submit').click(function(event) {
		if ($('#form').attr('edit')) {
			var _YX = ''
			$('input[type="radio"]:checked').each(function(index, el) {
				_YX += $(el).val()
			});
			$('input[name="declares"]').val(_YX);
		}
		fm5WhetherChange();
		$.fn.whetherMust(rulesAll, true).allAddValidata(rulesAll); //是必填
		checkStatus = 1;
		save_form.submit();
	});
	(new(require('zyw/publicOPN'))()).addOPN([{
		name: ($("#checkPoint").val() === undefined || $("#checkPoint").val() === '') ? '暂存':'',
		alias: 'temporarStorage',
		event: function() {
				if ($('#form').attr('edit')) {
					var _YX = ''
					$('input[type="radio"]:checked').each(function(index, el) {
						_YX += $(el).val()
					});
					$('input[name="declares"]').val(_YX);
				}
				fm5WhetherChange();
				rulesAllFalse();
				toIndex = -1;
				save_form.submit();
			}
			// },
			// {
			//     name: '提交',
			//     alias: 'fulfilSubmit',
			//     event: function() {
			//         //console.log(1111)
			//     }
	}]).init().doRender();

    $('#tempSave,#saveSubmit').click(function () {
        fm5WhetherChange();
        rulesAllFalse();
        toIndex = -1;
        save_form.submit();
    })

	var popupWindow = require('zyw/popupWindow');
	var hintPopup = require('zyw/hintPopup');

	$('body').on('click', '.relevanceBtn', function(event) {

		fundDitch = new popupWindow({ //关联单据

			YwindowObj: {
				content: 'relevanceScript', //弹窗对象，支持拼接dom、template、template.compile
				closeEle: '.close', //find关闭弹窗对象
				dragEle: '.newPopup dl dt' //find拖拽对象
			},

			ajaxObj: {
				url: '/baseDataLoad/queryInvestigationProjects.json?customerId=' + $('[name="customerId"]').val() + '&fstatus=APPROVAL,SUBMIT,AUDITING&busiType=' + $('[name="busiType"]').val(),
				type: 'post',
				dataType: 'json',
				data: {
					// isChargeNotification: "IS",
					// projectCode: _projectCode,
					pageSize: 6,
					pageNumber: 1
				}
			},
			// formAll: { //搜索
			// 	submitBtn: '#PopupSubmit', //find搜索按钮
			// 	formObj: '#PopupFrom', //find from
			// 	callback: function($Y) {

			// 	}
			// },
			pageObj: { //翻页
				clickObj: '.pageBox a.btn', //find翻页对象
				attrObj: 'page', //翻页对象获取值得属性
				jsonName: 'pageNumber', //请求翻页页数的dataName
				callback: function($Y) {

					//console.log($Y)

				}
			},

			callback: function($Y) {

				$Y.wnd.on('click', 'a.choose', function(event) {

					var _this = $(this);

					$('[name="copiedFormId"]').val(_this.parents('tr').attr('copiedFormId'));

					$('[trigger="temporarStorage"]').click();

				});

			},

			console: false //打印返回数据

		});


	});

	
	
	$('body').on('change','input[type="radio"]', function(){
		var _this = $(this),
		_parents = _this.parents('dl')
		if (!_parents.parents('.newPopup.newPopupMeat').length){
			var _checked = _parents.find('input[type="radio"]:checked'),
				_length = _checked.length,
				_YX = '';
			_checked.each(function(index, el) {
				_YX += $(el).val();
			});
			$('input[name="declares"]').val(_YX).attr('test',_YX);
		}
	})
	
});