/*
 * JQuery UI Search Combo Box v1.0
*/

Chosen.prototype.choice_build = function(item) {
  var choice_id, html, link,
  _this = this;
  
  if (this.is_multiple && this.max_selected_options <= this.choices) {
    this.form_field_jq.trigger("liszt:maxselected", {
      chosen: this
    });
    return false;
  }
  
  if (this.options.onechoice){
	  this.container.find(".chzn-choices a").each(function(ix, link){
		  _this.choice_destroy($(link));
	  });
  }
  
  choice_id = this.container_id + "_c_" + item.array_index;
  this.choices += 1;
  if (item.disabled) {
    html = '<li class="search-choice search-choice-disabled" id="' + choice_id + '"><span>' + item.html + '</span></li>';
  } else {
    html = '<li class="search-choice" id="' + choice_id + '"><span>' + item.html + '</span><a href="javascript:void(0)" class="search-choice-close" rel="' + item.array_index + '"></a></li>';
  }
  
  this.search_container.before(html);
  this.options.onechoice && this.search_container.hide();
  link = $('#' + choice_id).find("a").first();
  
  return link.click(function(evt) {
    return _this.choice_destroy_link_click(evt);
  });
}; 

Chosen.prototype.choice_destroy = function(link) {
  if (this.result_deselect(link.attr("rel"))) {
    this.choices -= 1;
	this.show_search_field_default();
    
	if (this.is_multiple && this.choices > 0 && this.search_field.val().length < 1) {
	 this.results_hide();	 
    }
	
    link.parents('li').first().remove();
    this.options.onechoice && this.search_container.show();
	return this.search_field_scale();
  }
};

Chosen.prototype.show_search_field_default = function() {
  if (this.is_multiple && this.choices < 1 && !this.active_field) {
	this.search_field.val(this.default_text);
	this.options.onechoice && this.search_container.show();
	return this.search_field.addClass("default");
  } 
  else {
	this.search_field.val("");
	return this.search_field.removeClass("default");
  }
}; 

Chosen.prototype.set_up_html = function() {
	var container_classes, container_props, me = this;

    this.container_id = this.form_field.id.length ? this.form_field.id.replace(/[^\w]/g, '_') : this.generate_field_id();
    this.container_id += "_chzn";
    container_classes = ["chzn-container"];
    container_classes.push("chzn-container-" + (this.is_multiple ? "multi" : "single"));
    
    if (this.inherit_select_classes && this.form_field.className) 
      container_classes.push(this.form_field.className);
    
    if (this.is_rtl) 
      container_classes.push("chzn-rtl");
    
    container_props = {
      'id': this.container_id,
      'class': container_classes.join(' '),
      'style': "width: " + (this.container_width()) + ";",
      'title': this.form_field.title
    };
    this.container = $("<div />", container_props);
    if (this.is_multiple) 
      this.container.html('<ul class="chzn-choices"><li class="search-field"><input type="text" value="' + this.default_text + '" class="default" autocomplete="off" style="width:25px;" /></li></ul><div class="chzn-drop"><ul class="chzn-results"></ul></div>');
    else
      this.container.html('<a href="javascript:void(0)" class="chzn-single chzn-default" tabindex="-1"><span>' + this.default_text + '</span><div><b></b></div></a><div class="chzn-drop"><div class="chzn-search"><input type="text" autocomplete="off" /></div><ul class="chzn-results"></ul></div>');
    
    var plugins = [ "json_data", "themes", "types", "ui" ];
    if (!me.options.onechoice)
    	plugins.push("checkbox");
    
    me.dlg = $("<div>").searchdlg({ 
    	autoReload: me.options.autoReload,
    	doselect: function(){
    		me.form_field_jq.children().remove();	
		    var id, v, nodes = [];
		    
		    if (me.options.onechoice)
		    {
		    	var nd = $(this.tree.jstree('get_selected')[0]);
		    		id = nd.attr('id');
		    	nodes.push(id);
		    		
		    	v = $("<option></option>").attr("value", id).text($.trim(nd.children('a:eq(0)').text()));
			    me.form_field_jq.append(v);
			    
			    me.search_container.hide();
		    }
		    else {
		      this.tree.jstree('get_checked').each(function(ix, nd){
			    nd = $(nd);
							
			    id = nd.attr('id');		 						
			    nodes.push(id);
	 						
			    v = $("<option></option>").attr("value", id).text($.trim(nd.children('a:eq(0)').text()));
			    me.options.struct && v.attr("rel", nd.attr("rel"));
			    
			    me.form_field_jq.append(v);
		      });		 				
		    }
		    this.close();
		    me.form_field_jq.val(nodes).trigger("liszt:updated");
    	},    	
    	struct: me.options.struct,
    	title: me.options.title,
    	tree_config: {
    		checkbox: { two_state: !me.options.struct },				 		
		 	json_data: {
		 		ajax: {				 			
		 			url: me.options.api.read,
					data: function(n) { 
						var obj = me.options.api.data || {};
						if (n.attr)
						{
							obj.id = n.attr("id");
							(me.options.struct) && (obj.kind = n.attr('rel'));
						}
						return obj; 
					} 
		 		}
		 	},				
		 	plugins: plugins		 	
		}
    });
   
    this.container.after($('<span>').addClass("ui-helper-hidden-accessible"));        
    this.wrapper = $("<a>").attr("tabIndex", -1).attr("title", "Поиск");
    this.container.after(this.wrapper);
   
    this.wrapper.button({
      icons: { primary: "ui-icon-grip-dotted-horizontal" },
      text: false
    }).removeClass("ui-corner-all").addClass("ui-corner-right ui-combobox-toggle")         
    .click(function() { me.dlg.searchdlg("open"); });	
   
    this.form_field_jq.hide().after(this.container);
    this.dropdown = this.container.find('div.chzn-drop').first();
    this.search_field = this.container.find('input').first();
    this.search_results = this.container.find('ul.chzn-results').first();
    this.search_field_scale();
    this.search_no_results = this.container.find('li.no-results').first();
    if (this.is_multiple) {
      this.search_choices = this.container.find('ul.chzn-choices').first();
      this.search_container = this.container.find('li.search-field').first();
    } else {
      this.search_container = this.container.find('div.chzn-search').first();
      this.selected_item = this.container.find('.chzn-single').first();
    }
    this.results_build();
    this.set_tab_index();
    this.set_label_behavior();
    return this.form_field_jq.trigger("liszt:ready", { chosen: this });
};

Chosen.prototype.winnow_results = function() {
	var me = this, searchText;
    this.no_results_clear();
    searchText = this.search_field.val() === this.default_text ? "" : $('<div/>').text($.trim(this.search_field.val())).html();        
    
    if (searchText.length >= me.options.minChars)
    {	    	
    	var data = me.options.api.data || {};
		data.q = searchText;
		
    	me.wrapper.button('option', { icons: { primary: "ui-loading" } });
    	
    	$.ajax({
    		type: "get",
			url: me.options.api.search,
			data: data,			 
			success: function(data, status){
				if (data.success){
					
					if (data.data.length < 1){
						me.no_results(searchText);
					}
					else {
						var v;
						
						me.options.onechoice && me.form_field_jq.empty().append(v);
						$.each(data.data, function(i, o){
							v = $("<option></option>").attr("value", o.id).text(o.name);	 					
							me.form_field_jq.append(v);							
						});					
						me.form_field_jq.trigger("liszt:updated");
				    }
					
					me.wrapper.button('option', { icons: { primary: "ui-icon-grip-dotted-horizontal" } });					
				}
			},
			error: function(data, status){
				console.log('err');
				me.wrapper.button('option', { icons: { primary: "ui-icon-grip-dotted-horizontal" } });
			} 
    	});
    }
   // base
    else {    
      var found, option, part, parts, regex, regexAnchor, result, result_id, results, startpos, text, zregex, _i, _j, _len, _len1, _ref;
      results = 0;    
      regexAnchor = this.search_contains ? "" : "^";
      regex = new RegExp(regexAnchor + searchText.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&"), 'i');
      zregex = new RegExp(searchText.replace(/[-[\]{}()*+?.,\\^$|#\s]/g, "\\$&"), 'i');
      _ref = this.results_data;
    
      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
        option = _ref[_i];
        if (!option.disabled && !option.empty) {
          if (option.group) {
            $('#' + option.dom_id).css('display', 'none');
          } else if (!(this.is_multiple && option.selected)) {
            found = false;
            result_id = option.dom_id;
            result = $("#" + result_id);
            if (regex.test(option.html)) {
              found = true;
              results += 1;
            } else if (this.enable_split_word_search && (option.html.indexOf(" ") >= 0 || option.html.indexOf("[") === 0)) {
              parts = option.html.replace(/\[|\]/g, "").split(" ");
              if (parts.length) {
                for (_j = 0, _len1 = parts.length; _j < _len1; _j++) {
                  part = parts[_j];
                  if (regex.test(part)) {
                    found = true;
                    results += 1;
                  }
                }
              }
            }
            if (found) {
              if (searchText.length) {
                startpos = option.html.search(zregex);
                text = option.html.substr(0, startpos + searchText.length) + '</em>' + option.html.substr(startpos + searchText.length);
                text = text.substr(0, startpos) + '<em>' + text.substr(startpos);
              } else {
                text = option.html;
              }
              result.html(text);
              this.result_activate(result);
              if (option.group_array_index != null) {
                $("#" + this.results_data[option.group_array_index].dom_id).css('display', 'list-item');
              }
            } else {
              if (this.result_highlight && result_id === this.result_highlight.attr('id')) {
                this.result_clear_highlight();
              }
              this.result_deactivate(result);
            }
          }
        }
      }
      if (results < 1 && searchText.length) {
        return this.no_results(searchText);
      } else {
        return this.winnow_results_set_highlight();
      }    
    }
    
};