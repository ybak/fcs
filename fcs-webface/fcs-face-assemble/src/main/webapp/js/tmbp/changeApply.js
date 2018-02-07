/**
 * 一天一个样
 * 
 * 2016.07.11 fnChangeApplys 只要一个大概的变化就好了
 * 
 * 
 */

define(function(require, exports, module) {

	var md5 = require('md5'), util = require('util');

	var FILETYPE = util.fileType.all.replace(/(\*|\s)/ig, '').split(';'), fileReg = [];

	// $.each(FILETYPE.split(';'), function(i, o) {
	// fileReg.push('\\' + o + '$');
	// });
	// var fileRegExp = new RegExp('(' + fileReg.join('|') + ')', 'ig');

	function getAllChangeApply(select) {

		var dataList = {
			single : [],
			complex : []
		}, select = select || 'body';
		// 遍历所有可能改变的模块
		$(select).find('.fnChangeApply:visible,.fnChangeApply.fnChangeApplyMust').each(function(index, el) {

			var $fnChangeApply = $(this), $fnChangeInput = $fnChangeApply.find('.fnChangeInput');

			// 判断是单例还是数组
			if ($fnChangeInput.length > 1) {
				// 多个
				dataList.single.push(getChangeObj($fnChangeInput))
			} else {
				// 单例
				dataList.single.push(getObj($fnChangeInput));
			}

		});

		$(select).find('.fnChangeApplys:visible,.fnChangeApplys.fnChangeApplyMust').each(function(index, el) {

			// var $fnChangeApplys = $(this),
			// $item = $fnChangeApplys.find('.fnChangeItem:visible'),
			// _listItem = [];

			// $item.each(function(i, e) {

			// var $fnChangeApply = $(this),
			// $fnChangeInput = $fnChangeApply.find('.fnChangeInput');

			// // 判断是单例还是数组
			// if ($fnChangeInput.length > 1) {
			// // 多个
			// _listItem.push(getChangeObj($fnChangeInput))
			// } else if ($fnChangeInput.length == 1) {
			// // 单例
			// _listItem.push(getObj($fnChangeInput));
			// }

			// });

			// if (!!!$item.length) {
			// // 占空位
			// _listItem.push({
			// label: '',
			// name: '',
			// value: '',
			// text: ''
			// })
			// }

			var $fnChangeApplys = $(this), $item = $fnChangeApplys.find('.fnChangeItem:visible,.fnChangeApplys.fnChangeApplyMust'), _listItem = {
				label : $fnChangeApplys.find('.fnChangeLabel').eq(0).text().replace(/\s/g, ''),
				name : $fnChangeApplys.find('.fnChangeItem').eq(0).attr('orderName') || $fnChangeApplys.find('.fnChangeItem').eq(0).attr('diyName'),
				md5 : getApplysValue($item)
			};

			dataList.complex.push(_listItem);

		});
		//console.log(dataList);
		return dataList;

	}

	function getApplysValue($list) {

		var _val = '';

		$list.each(function(index, val) {

			$(this).find('.fnChangeInput').each(function(i, e) {

				_val += e.value;

			});

		});

		return md5(_val);

	}

	function getObj($el) {
		// 感觉这里是找到保存的地方
		// console.log($el);
		var el = $el[0], label = $el.parents('.fnChangeApply').find('.fnChangeLabel').eq(0).text().replace(/\s/g, ''), type = el.type || el.tagName;
		if ($el.parent('.fnChangeLabels').length) {
			label = $el.parent().find('.fnChangeLabel').eq(0).text().replace(/\s/g, '')
		}

		if (!label) {
			label = $el.parents('.fnChangeItem').find('.fnChangeLabel').eq(0).text().replace(/\s/g, '');
		}

		switch (type) {
		case 'hidden':
		case 'text':
		case 'textarea':
			return {
				label : label,
				name : el.name,
				value : getFilesHtml(el.value),
				text : getFilesHtml(el.value)
			};
			break;
		case 'radio':
		case 'checkbox':
			var o = {
				label : label,
				name : el.name
			};
			if ($el.prop('checked')) {
				o.value = el.value;
				o.text = $el.parent().text().replace(/\s/g, '');
			}
			return o;
			break;
		case 'SELECT':
		case 'select-one':
			var value = el.value, text = $el.find('option[value="' + value + '"]').text().replace(/\s/g, '');
			return {
				label : label,
				name : el.name,
				value : value,
				text : text
			}
			break;
		}

	}

	function getChangeObj($inputs) {

		var _arr = [];

		$inputs.each(function(index, el) {

			var _obj = getObj($inputs.eq(index));

			if (_obj) {
				_arr.push(_obj)
			}

		});

		return _arr;

	}

	function contrast(objNew, objOld) {

		var arrDifference = [];

		$.each(objNew.single, function(index, obj) {

			var _new = obj, _old = objOld.single[index];

			if ($.isArray(_new)) {

				var _arrNewValue = [], _arrOldValue = [], _arrNewText = [], _arrOldText = [], _label = '', _name = '';
				$.each(_new, function(i, o) {
					if (o.value) {
						_arrNewValue.push(o.value);
						_arrNewText.push(o.text);
					}
					_label = o.label;
					_name = o.name;
				});
				$.each(_old, function(i, o) {
					if (o.value) {
						_arrOldValue.push(o.value);
						_arrOldText.push(o.text);
					}
					_label = o.label;
					_name = o.name;
				});
				if (_arrNewValue.join(',') != _arrOldValue.join(',')) {

					arrDifference.push({
						label : _label,
						name : _name,
						oldText : _arrOldText.join(','),
						newText : _arrNewText.join(','),
						oldValue : _arrOldValue.join(','),
						newValue : _arrNewValue.join(',')
					});
				}

			} else {

				if (!!!_old || _old.value != _new.value) {
					arrDifference.push({
						label : _new.label,
						name : _new.name,
						oldText : _old ? _old.text : '',
						newText : _new.text,
						oldValue : _old ? _old.value : '',
						newValue : _new.value
					});
				}

			}

		});

		$.each(objNew.complex, function(index, arr) {
			var newArr = arr, oldArr = objOld.complex[index];

			if (!!!oldArr || newArr.md5 != oldArr.md5) {
				arrDifference.push({
					label : newArr.label,
					name : newArr.name,
					newValue : '有改动',
					newText : '有改动',
					group : true
				});

			}

		});

		var _resArr = [], _resArrName = [];

		// 剔除 空白、重复name
		$.each(arrDifference, function(index, el) {

			// 过滤 ':*'
			el.label = el.label.replace(/(\：|\*)/g, '');

			if (el.name && $.inArray(el.name, _resArrName) == -1) {

				// 判断当前 el.newText 是否是附件
				// 附件可能是数组或是单个地址

				if (el.newText) {
					// el.newText = getFilesHtml(el.newText);
					el.newText = el.newText
				}

				if (el.oldText) {
					el.oldText = el.oldText
				}

				_resArr.push(el);
				_resArrName.push(el.name);
			}

		});

		return _resArr;

	}

	function getFilesHtml(files) {

		var _filesArr = files.split(';'), _fileHtml = '';

		$.each(_filesArr, function(i, o) {

			var _fileArr = o.split(','), _fileTypes = (_fileArr[0] || '').split('.'), _fileType = '.' + _fileTypes[_fileTypes.length - 1];

			if (_fileArr.length == 1) {

				// 可能是单个url
				if ($.inArray(_fileType, FILETYPE) > -1) {

					_fileHtml += getFileHtml(_fileArr[0], _fileArr[0], _fileArr[0]);

				}

			} else if (_fileArr.length == 3) {
				// 可能是多个
				if ($.inArray(_fileType, FILETYPE) > -1) {

					_fileHtml += getFileHtml(_fileArr[0], _fileArr[2], _fileArr[1]);

					// if (util.isImg(_fileArr[0])) {
					// _fileHtml += getFileHtml(_fileArr[0], _fileArr[2], '-');
					// } else {
					// _fileHtml += getFileHtml(_fileArr[0], _fileArr[2],
					// _fileArr[1]);
					// }
				}

			}

		});
		if (_fileHtml) {
			return '<span class="m-attach fnUpAttachUl">' + _fileHtml + '</span>'
		} else {
			return files
		}

	}

	function getFileHtml(fileName, url, serverPath) {

		var IS_PREVIEW = /(.pdf|.doc|.docx|.xls|.xlsx|.ppt|.pptx)$/gi

		var IS_PDF = /.pdf$/gi

		var _isPreview = IS_PREVIEW.test(fileName)

		var _preview = IS_PDF.test(fileName) ? url : '/projectMg/contract/excelMessage.htm?contractItemId=0&read=read&hidTitle=hidTitle&fileName=' + fileName + '&fileUrl=' + serverPath + '&id=0'

		var _fullPath = [ fileName, serverPath, url ].join(',')

		var _download = '/baseDataLoad/downLoad.htm?fileName=$!stringUtil.encodeURI(' + fileName + ')&path=' + serverPath + '&id=0'

		var _item = ''

		if (util.isImg(fileName)) {

			_item += '<i class="icon icon-img"></i><span class="fnAttachView fn-csp">' + fileName + '</span>'

		} else {

			_item += '<i class="icon icon-file"></i><a title="点击下载" download target="_blank" href="' + _download + '">' + fileName + '</a>'

			if (_isPreview) {
				_item += '<a class="attach-item-preview" href="' + _preview + '" target="_blank">预览</a>'
			}

		}

		return '<span class="attach-item fnAttachItem" val="' + _fullPath + '">' + _item + '</span>'

		// return [
		// '<span class="attach-item fnAttachItem" val="' + [name, serverPath,
		// url].join(',') + '">',
		// ' <i class="icon ' + (IS_IMG.test(name) ? 'icon-img' : 'icon-file') +
		// '"></i><span class="fnAttachView fn-csp">$!{item.fileName}</span>',
		// IS_PREVIEW.test(name) ? '<a class="attach-item-preview" href="' +
		// _preview + '" target="_blank">预览</a>' : '',
		// '</span>'
		// ].join('')

		// return '<a class="fn-mr5" href="' + url + '" target="_blank">' + name
		// + '</a>'

	}

	function getHtml(select, obj) {

		/**
		 * obj = { addClass -> m-change single: [], -> fnChangeApply complex: [] ->
		 * fnChangeApplys }
		 */

		select = (typeof select == 'string') ? select : '';
		obj = (typeof select == 'object') ? select : obj;

		var $div = $('<div></div>'), select = select || 'body', $original = $(select);

		$div.html($original.html());

		// 添加标记
		if (obj) {

			$.each(obj.single, function(i, o) {

				$div.find('[name="' + o + '"]').parents('.fnChangeApply').addClass('m-change');

			});

			$.each(obj.complex, function(i, o) {

				$div.find('[orderName="' + o + '"],[diyname="' + o + '"]').parents('.fnChangeApplys').addClass('m-change');

			});

		}

		var $allInput = $div.find('input,select,textarea:not(#ueditor_textarea_editorValue)');

		// .fnChangeApplyHidden
		$div.find('.fn-input-hidden:not(.fnMakeUE, .fnChangeInput), .fnChangeApplyHidden,.edui-editor,.edui-default').remove();

		$original.find('input,select,textarea:not(#ueditor_textarea_editorValue)').each(function(index, el) {

			var $el = $(this);
			if (el.type == 'radio' || el.type == 'checkbox') {
				// $allInput.eq(index).parent().remove();
				if (getValue($el)) {
					$allInput.eq(index).remove();
				} else {
					// 如果父级是label标签
					var $input = $allInput.eq(index)
					var $parent = $input.parent()
					$parent.is('label') ? $input.parent().remove() : $input.remove()
					// $allInput.eq(index).parent().remove()
				}
			} else {

				if ($el.hasClass('fnMakeUE')) {
					// 如果是富文本框
					$el.parent().addClass('contract-text')
				}

				$allInput.eq(index).after(getValue($el)).remove();

			}

		});

		$div.find('.fn-hide,script,.fnAddLine,.ui-btn,.attach-del,span.hint,.fnDelLine').remove();

		return $div.html();

	}

	function getValue($el) {

		var el = $el[0], type = el.type || el.tagName;

		switch (type) {
		case 'text':
		case 'textarea':
			return el.value;
			break;
		case 'radio':
		case 'checkbox':
			if ($el.prop('checked')) {
				return $el.parent().text().replace(/\s/g, '')
			} else {
				return false;
			}
			break;
		case 'SELECT':
		case 'select-one':
			var value = el.value, text = $el.find('option[value="' + value + '"]').text().replace(/\s/g, '');
			return $el.find('option[value="' + value + '"]').text().replace(/\s/g, '');
			break;
		}

	}

	module.exports = {
		getAllChangeApply : getAllChangeApply,
		contrast : contrast,
		getHtml : getHtml
	}

});