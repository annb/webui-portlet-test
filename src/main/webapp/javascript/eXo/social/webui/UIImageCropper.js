(function($, socialPlugin, jWCropper) {
	var _module = {};

	function UIImageCropper() {
	};

	UIImageCropper.prototype.init = function(params) {
		var cropLabel = params.cropLabel || null;
		var selectionExists;

		$('input#croppedInfo')[0].type = 'hidden';
		var cropActionBtn = $('a#cropAction');
		var onclickAttr = cropActionBtn.attr('onclick');

		cropActionBtn.addClass('DisableButton');
		cropActionBtn.attr("onclick", '');

		$('img#profileAvatar').jWindowCrop({
			targetWidth: 240,
			targetHeight: 240,
			loadingText: 'hello world',
			onChange: function(result) {
				updateForm(result);
				$('#crop_x').text(result.cropX);
				$('#crop_y').text(result.cropY);
				$('#crop_w').text(result.cropW);
				$('#crop_h').text(result.cropH);
			}
		});
		
	};
	
	function updateForm(crop) {
		var x = crop.cropX;
		var y = crop.cropY;
		var w = crop.cropW;
		var h = crop.cropH;
		var croppedInfo = [];
		croppedInfo.push("X:" + x, "Y:" + y, "WIDTH:" + w, "HEIGHT:" + h);

		$('input#croppedInfo').val(croppedInfo.join());

//		selectionExists = crop.selectionExists();

		var cropActionButton = $("a#cropAction");
//		if (selectionExists) {
			cropActionButton.removeClass('DisableButton');
			cropActionButton.attr("onclick", onclickAttr);
//		} else {
//			cropActionButton.addClass('DisableButton');
//			cropActionButton.attr("onclick", '');
//		}
	};

	_module.UIImageCropper = new UIImageCropper();

	return _module;
})($, socialPlugin, jWCropper)
