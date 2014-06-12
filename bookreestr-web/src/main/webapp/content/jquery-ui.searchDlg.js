if (!Array.filter) {
    Array.prototype.filter= function(filter, that /*opt*/) {
        var i = 0, other= [], v;
        for (i, n = this.length; i < n; ++i)
            if (i in this && filter.call(that, v = this[i], i, this))
                other.push(v);
        return other;
    };
}

if (!Array.indexOf) {
	Array.prototype.indexOf = function (obj, start) {
		var i = start || 0;
		for (i; i < this.length; ++i) {
			if (this[i] == obj) 
				return i;			
		}
		return -1;
	};
}

(function($){
	$.widget("ui.searchdlg", $.ui.dialog, {
		options: {
			autoOpen: false,
			autoReload: false,
			modal: true,		
			height: 480,
			width: 680,
			hierarchy: 1,
			buttons: [ { text: "Выбрать", click: function() { $(this).trigger('doselect'); }, 'class': 'btnsel', disabled: true },
			           { text: "Отмена", click: function() { $(this).searchdlg('close'); } } ]
	  },
	  _create: function() {
	      
		  var me = this;
		  if (me.options.hierarchy){
			  me.tree = $('<div class="tree">');
			  me.element.append(me.tree);
		  }
		  else {			
			  var ix = Math.floor(Math.random() * 101);			  
			  me.grid = $('<table id="searchtable_' + ix + '">');			  
			  me.element.append(me.grid).append(me.pager);
		  }
			
		  $.ui.dialog.prototype._create.call(me);
		  
		  me.btnsel = me.element.nextAll('.ui-dialog-buttonpane').find('button.btnsel');		  
		  me.options.doselect && me.element.bind('doselect', function(){
			  me.options.doselect.call(me); 
		  });
	  },	  
	  _destroy: function () {
		  var me = this;
		  
		  (me.options.hierarchy) ? me.tree.remove() : me.grid.remove();		  
          $.ui.dialog.prototype.destroy.call(this);
      },
	  _initview: function(){		  
		  var me = this;		  
		  if (me.options.hierarchy)
		  {
			  var tree_config = {
                  core: { strings: { loading: 'Загрузка' } },
                  plugins: ["json_data", "themes", "types", "ui"],                  
                  themes: { theme: "apple" },
                  ui: { select_limit: 1, select_prev_on_delete: false }
			  };			  
			  		
			  if (me.options.struct) {
				  tree_config.types = {
				      valid_children: [ "0" ],
				      types: {					
						  "0": { icon: { image: "/doclib/content/images/org.png" }, valid_children: [ "0", "1" ] },
						  "1": { icon: { image: "/doclib/content/images/dept.png" }, valid_children: [ "1", "2" ] },
						  "2": { icon: { image: "/doclib/content/images/user.png" }, valid_children: "none" }
				      }
				  };
				  
				  me.tree.bind("loaded.jstree", function (e, data) {              
					  $(this).find('li').each(function(ix, nd){
			              me.tree.jstree('open_node', nd);
					  });            
				  });       	
		  	  }
			  
			  $.extend(true, tree_config, me.options.tree_config);	
			  
			  me.tree.jstree(tree_config)
			  .bind('dblclick.jstree', function (e) {			     		    		
				  var nd = $(e.target).closest('li');
				  (!nd.hasClass('jstree-leaf') && nd.attr('rel') != 2) && $(this).jstree('toggle_node', nd);	    			
			  });
			  
			  if (me.multiselect = (tree_config.plugins.indexOf("checkbox") > -1))			  
			  {
				  me.tree.bind('check_node.jstree', function (e, data) {
					  me.btnsel.button({ disabled: false });
				  })
				  .bind('uncheck_node.jstree', function (e, data) {			     		    		
					  if ($(this).jstree('get_checked').length === 0)
						  me.btnsel.button({ disabled: true });
				  });
			  }
			  else {
				  me.tree.bind('deselect_node.jstree', function (e, data) {
					  me.btnsel.button({ disabled: true });    		
				  })	
				  .bind('select_node.jstree', function (e, data) {			     		    		
					  me.btnsel.button({ disabled: false });    		
				  });				  
			  }
		  }
		  else {
			  var grid_config = {
			      datatype: 'json',			      
			      autowidth: true,
			      ignoreCase: true,
			      loadonce: true,	
			      rownumbers: true,		
			      sortable: true,
			      height: me.options.height - 180
			  };
			  
			  $.extend(grid_config, me.options.grid_config);			  
			  (grid_config.pager) && me.grid.after('<div id ="' + grid_config.pager.substr(1) + '">');
			  
			  me.grid.jqGrid(grid_config);			  
			  (grid_config.pager) && me.grid.navGrid(grid_config.pager, { edit: false, add: false, del: false, search: false });			  
		  }
	  },
	  close: function(){
		  var me = this;
		  
		  (me.options.doclose) && me.options.doclose.call(me);
		  $.ui.dialog.prototype.close.call(this);
	  },
	  open: function(){
		  var me = this;
		  
		  if (!me.loaded) {			  
			  me._initview();
			  me.loaded = 1;			  
		  }
		  else
		  {  
			  if (me.options.hierarchy)
			  {
				  if (me.options.autoReload)
					  me.tree.jstree('refresh');				  
				  
				  else {
					  if (me.multiselect) {
						  me.tree.find('li.jstree-checked').each(function(ix, nd){
							  me.tree.jstree('uncheck_node', nd);
						  });
					  }
				  
					  if (!me.options.struct)  
						  me.tree.jstree("close_all", -1);
					  
					  else {
						  me.tree.find('li.jstree-open').each(function(ix, nd){
							  if ($(nd).attr('rel') > 0)
								  me.tree.jstree('close_node', nd);
						  });
					  }
				  
					  me.tree.jstree('deselect_all');
			  	  }  
			  }
			  else {
				   if (me.options.autoReload && me.grid.getGridParam('url')) 
					  me.grid.jqGrid('clearGridData').setGridParam({ datatype: 'json' }).trigger('reloadGrid', [{ page: 1 }]);				  
			  }
		  }	
		  $.ui.dialog.prototype.open.call(this);
	  }
	});
})(jQuery);