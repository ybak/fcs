define(function(require, exports, module) {
	// 项目管理 > 风险管控 > 上会申报记录
	require('zyw/publicPage');
	require('Y-msg');
	var util = require('util');

	$('#list').on('click', '.end', function() {
		var _this = $(this);
		if (_this.hasClass('ing')) {
			return;
		}
		_this.addClass('ing');
		var reportId = _this.attr("reportId");
		Y.confirm('信息提醒', '针对本次汇报，您操作了删除，是否确认？', function(opn) {
			if (opn == 'yes') {
				util.ajax({
					url: "/projectMg/projectRiskReport/delete.json",
					data: {
						reportId: reportId
					},
					success: function(res) {
						if (res.success) {
							Y.alert('消息提醒', res.message, function() {
								window.location.reload(true);
							});
						} else {
							_this.removeClass('ing');
							Y.alert('消息提醒', res.message);
						}
					}
				});
			} else {
				_this.removeClass('ing');
			}
		});
	})

});