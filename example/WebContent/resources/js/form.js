(function () {
	var window = this,
		document = window.document,
		documentElement = document.documentElement,
		$ = window.jQuery,
		$document = $(document),
		msie = $.browser.msie && parseFloat($.browser.version);

	/* Selectbox */
	$.fn.selectbox = function (config) {
		var defaults = {
				wrapperClass: "selectbox_wrap",
				disabledClass: "selectbox_disabled",
				scrollClass: "selectbox_scroll",
				valueHolderClass: "value_holder",
				optionListClass: "new_selectbox",
				selectedClass: "selected",
				hoverClass: "hover",
				scrollSize: 8,
				zIndex: 10,
				speed: 100
			},
			$body = $(document.body);
		config = $.extend({}, defaults, config);
		window._openedSelect = null;
		if (!$body.data("closeSet.selectbox")) {
			$body
				.bind("click.selectbox", function (e) {
					if (_openedSelect && _openedSelect.length && !$.contains(_openedSelect.data("wrapper.selectbox")[0], e.target)) {
						var $optionList = _openedSelect.data("optionList.selectbox");
						if ($optionList && $optionList.length) {
							$optionList.trigger("close.selectbox");
						}
					}
				})
				.data("closeSet.selectbox", true);
		}
		return this.each(function () {
			var select = this,
				$select = $(select),
				$selectbox = null,
				$valueHolder = null,
				$optionList = null,
				$ie6Iframe = null;
			if (select.reGen) {
				select.reGen();
			} else {
				generate();
			}
			if (!select.reGen) {
				select.reGen = function () {
					$selectbox = $select.data("wrapper.selectbox");
					$valueHolder = $select.data("valueHolder.selectbox");
					$optionList = $select.data("optionList.selectbox");
					$ie6Iframe = $select.data("ie6Iframe.selectbox");
					$optionList
						.empty()
						.append(generateList());
					if ($valueHolder.length && select.selectedIndex > -1) {
						$valueHolder.val(select.options[select.selectedIndex].text);
					}
					if (select.className) {
						$select.addClass(select.className);
					}
					if (select.disabled) {
						$select.addClass(config.disabledClass);
					} else {
						$select.removeClass(config.disabledClass);
					}
					if (config.scrollSize > 0 && select.length > config.scrollSize) {
						$optionList.addClass(config.scrollClass);
					} else {
						$optionList.removeClass(config.scrollClass);
					}
					setSize();
				};
			}
			// 이전 버전 호환성 위해 남겨둠.
			select.close = function () {
				$optionList.trigger("close.selectbox");
			};
			// 셀렉트박스 생성
			function generate() {
				var html = ["</ul><span></span></div>"];

				html.push(generateList());
				html.push('<!--[if lt IE 7]><iframe src="about:blank" frameborder="0" scrolling="no"></iframe><![endif]--><div class="' + config.optionListClass + '"><ul>');
				// size 혹은 multiple 속성값이 지정되어 있으면 버튼 생성 안함
				if (!(select.size || select.multiple)) {
					html.push('<input type="button" class="' + config.valueHolderClass + '" value="' + (select.selectedIndex > -1 ? select.options[select.selectedIndex].text : '') + '" />');
				}
				$selectbox = $select.after('<div class="' + config.wrapperClass + (select.className && ' ' + select.className) + '">').next("div." + config.wrapperClass);
				$selectbox.append(html.reverse().join(""));
				$valueHolder = $selectbox.find("input:button");
				$optionList = $selectbox.find("div");
				$ie6Iframe = $selectbox.find("iframe");
				if (select.disabled) {
					$selectbox.addClass(config.disabledClass);
				}
				if (config.scrollSize > 0 && select.length > config.scrollSize) {
					$optionList.addClass(config.scrollClass);
				}
				setSize();
				bindEvents();
				$select
					.data("wrapper.selectbox", $selectbox)
					.data("valueHolder.selectbox", $valueHolder)
					.data("optionList.selectbox", $optionList)
					.data("ie6Iframe.selectbox", $ie6Iframe);
			}
			// 옵션 목록 생성
			function generateList() {
				var i = select.length,
					options = select.options,
					html = [];
				while (i--) {
					html.push("</li>");
					html.push(options[i].text);
					html.push("<li>");
				}
				return html.reverse().join("");
			}
			// 셀렉트박스 사이즈 지정
			function setSize() {
				if (!$select.is(":visible")) {
					$select.css("display", "");
				}
				var width = parseInt($select.outerWidth()) - 2;
				$valueHolder.css("width", width + 40);
				$optionList.css("width", width + 38);
				if ($ie6Iframe.length) {
					$ie6Iframe.css({
						"width": width -70,
						"height": $optionList.outerHeight()
					});
				}
				$select.css("display", "none");
			}
			// 옵션 선택
			function selectOption(index) {
				if (!select.disabled) {
					var $options = $optionList.find("li");
					$options.eq(select.selectedIndex).removeClass(config.selectedClass);
					if ($valueHolder.length) {
						$valueHolder.val(select.options[index].text);
					}
					select.selectedIndex = index;
					$options.eq(select.selectedIndex).addClass(config.selectedClass);
					$select.trigger("change");
				}
			}
			// 생성된 셀렉트박스에 이벤트 할당
			function bindEvents() {
				// 옵션 목록 이벤트
				$optionList.bind({
					// 열기/닫기
					"open.selectbox": function () {
						$selectbox.css("zIndex", config.zIndex);
						$optionList
							.stop(true, true)
							.slideDown(config.speed)
							.data("isOpen.selectbox", true);
						_openedSelect = $select;
						if ($ie6Iframe.length) {
							$ie6Iframe
								.stop(true, true)
								.slideDown(config.speed);
						}
					},
					"close.selectbox": function () {
						$optionList
							.stop(true, true)
							.slideUp(config.speed, function () {
								$selectbox.css("zIndex", "");
							})
							.data("isOpen.selectbox", false);

						_openedSelect = null;

						if ($ie6Iframe.length) {
							$ie6Iframe
								.stop(true, true)
								.slideUp(config.speed);
						}
					},
					"toggle.selectbox": function () {
						if ($optionList.data("isOpen.selectbox")) {
							$optionList.trigger("close.selectbox");
						} else {
							$optionList.trigger("open.selectbox");
						}
					},
					// 이전, 다음 옵션 선택
					"next.selectbox": function () {
						var index = select.selectedIndex + 1;

						if (index < select.options.length) {
							selectOption(index);
						}
					},
					"prev.selectbox": function () {
						var index = select.selectedIndex - 1;

						if (index > -1) {
							selectOption(index);
						}
					}
				});
				// 각 옵션에 대한 이벤트
				$("li", $optionList[0]).live("click.selectbox mouseover.selectbox mouseout.selectbox", function (e) {
					var type = e.type;

					if (type === "click") {
						selectOption($optionList.find("li").index(this));
						$(this).parent("ul").trigger("close.selectbox");
					} else if (type === "mouseover") {
						$(this).addClass(config.hoverClass);
					} else if (type === "mouseout") {
						$(this).removeClass(config.hoverClass);
					}
				});
				// 버튼 이벤트
				if ($valueHolder.length) {
					$valueHolder.bind({
						"click.selectbox": function () {
							if (!select.disabled) {
								$(".new_selectbox").css("display","none");
								$(".selectbox_wrap").css("z-index","");
								//$optionList.trigger("open.selectbox");
								$optionList.trigger("toggle.selectbox");
							}
						},
						"focusin.selectbox": function () {
							if (!select.disabled) {
								$(this).parent(".selectbox_wrap").addClass("focus");
							}
						},
						"focusout.selectbox": function () {
							if (!select.disabled) {
								$(this).parent(".selectbox_wrap").removeClass("focus");
							}
						},
						"keydown.selectbox": function (e) {
							if (!select.disabled) {
								if (e.keyCode === 40) { // 아래 화살표 키
									e.preventDefault();
									$optionList.trigger("next.selectbox");
								} else if (e.keyCode === 38) { // 위 화살표 키
									e.preventDefault();
									$optionList.trigger("prev.selectbox");
								} else if (e.keyCode === 9) {	// 탭 키
									$optionList.trigger("close.selectbox");
								}
							}
						}
					});
				}
			}
			// 셀렉트박스와 연결된 label 요소 반환
			function getLabels() {
			}
		});
	};
	/* On DOM Ready */
	$document.ready(function () {
		/* input radio, checkbox*/
		function setupLabel() {
			if ($('.label_check input').length) {
				$('.label_check').each(function(){
					$(this).removeClass('c_checked');
				});
				$('.label_check input:checked').each(function(){
					$(this).parent('label').addClass('c_checked');
				});
			};
			if ($('.label_radio input').length) {
				$('.label_radio').each(function(){
					$(this).removeClass('r_checked');
				});
				$('.label_radio input:checked').each(function(){
					$(this).parent('label').addClass('r_checked');
				});
			};
		};
		$('body').addClass('has_js');
		$('.label_check, .label_radio').click(function(){
			setupLabel();
		});
		$('.label_check input, .label_radio input').focusin(function(){
			$(this).parent('label').addClass('focus');
		});
		$('.label_check input, .label_radio input').focusout(function(){
			$(this).parent('label').removeClass('focus');
		});
		$('.label_check input').keypress(function(){
			$(this).parent('label').addClass('c_checked');
		});
		$('.label_radio input').keypress(function(){
			$(this).parent('label').addClass('r_checked');
		});
		setupLabel();
 
		/* Selectbox */
		$document.find('select:not([multiple], .detail select, .uxa-vero-reason select)').selectbox();
		
		/* 인증서 tab */
		$('#authenti2').css('display','none');
		$('.tab_text a').click(function() {
			$('.tab_text li').removeClass('selected');
			$(this).parent('li').addClass('selected');
			return false;
		});
		$('.tab_text li:nth-child(1) a').click(function() {
			$('#authenti1').css('display','block');
			$('#authenti2').css('display','none');
		});
		$('.tab_text li:nth-child(2) a').click(function() {
			$('#authenti1').css('display','none');
			$('#authenti2').css('display','block');
		});
	});
}());