(function($) {
	var _module = {};


	function UIImageCropper() {
		var cropActionBtn;
		var onclickAttr;
	};

	UIImageCropper.prototype.init = function(params) {
		var imageSource = params.imageSource || null;
		var imageAlt = params.imageAlt || null;

		$('input#croppedInfo')[0].type = 'hidden';
		cropActionBtn = $('a#cropAction');
		onclickAttr = cropActionBtn.attr('onclick');

		cropActionBtn.addClass('DisableButton');
		cropActionBtn.attr("onclick", '');

		var divImage = $('div#imageCropping');
		
		divImage.append("<img id='profileAvatar' src='"+imageSource+"' title='"+imageAlt+"' alt='"+imageAlt+"' class='crop_me'/>")
		
		var image = $('img#profileAvatar');
		
		image.load(function() {
			image.jWindowCrop({
				targetWidth : 240,
				targetHeight : 240,
				onChange : function(result) {
					$('#crop_x').text(result.cropX);
					$('#crop_y').text(result.cropY);
					$('#crop_w').text(result.cropW);
					$('#crop_h').text(result.cropH);
					updateForm(result);
				}
			});
		});
		
	};

	function updateForm(result) {		
		var x = result.cropX;
		var y = result.cropY;
		var w = result.cropW;
		var h = result.cropH;
		var croppedInfo = [];
		croppedInfo.push('X:' + x, 'Y:' + y, 'WIDTH:' + w, 'HEIGHT:' + h);
		$('input#croppedInfo').val(croppedInfo.join());

		var cropActionButton = $('a#cropAction');
		cropActionButton.removeClass('DisableButton');
		cropActionButton.attr('onclick', onclickAttr);
	};

	_module.UIImageCropper = new UIImageCropper();

	return _module;

})($)