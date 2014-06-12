<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<%-- security --%>
<c:set var="logged" value="0" />
<sec:authorize access="isAuthenticated()">
	<c:set var="logged" value="1" />
</sec:authorize>

<html>
<head>
	<jsp:include page="common.jsp"/>	
	<title>Реестр книг</title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/content/admin.css" />">
	<link type="text/css" rel="stylesheet" href="<c:url value="/content/chosen.css" />">
	<link type="text/css" rel="stylesheet" href="<c:url value="/content/jquery.contextMenu.css" />">
	<link type="text/css" rel="stylesheet" href="<c:url value="/content/layout-default-latest.css" />">
	<link type="text/css" rel="stylesheet" href="<c:url value="/content/ui.jqgrid.css" />">
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.form.js" />"></script>	
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.validate.min.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.contextMenu.js" />"></script>		
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.layout-latest.min.js" />"></script>	
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery-ui-messageBox.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.jqGrid.min.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/grid.locale-ru.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.jstree.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery-ui.searchDlg.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/chosen.jquery.min.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery-ui.searchCombo.js" />"></script>
	<script type="text/javascript" language="javascript" src="<c:url value="/content/jquery.showpassword.js" />"></script>		
	<script type="text/javascript">		
		var activePane = 0;	
	
		function activatePane(el){
			$(".ui-layout-center > div").each(function(){				
				var g = $(this);
				g[el == g.attr("id") ? 'removeClass' : 'addClass']("ui-helper-hidden");				
			});	
		}
		
		function doEdit(v){
			if (v){
				btnEdit.button('option', 'disabled', false);
				btnRemove.button('option', 'disabled', false);
			}
			else{
				btnEdit.button('option', 'disabled', true);
				btnRemove.button('option', 'disabled', true);
			}
		}
		
		function getValues(form){
			var fields = $(form).serializeArray(),
				v, obj = {};
			
			$.each(fields, function(i, f){
				v = f.value;			
				v && (obj[f.name] = v);						
			});
			
			return obj;	
		}
		
		function refresh(form){
			var fields = $(form).find("input, textarea").not(":checkbox");
			fields.removeClass("ui-state-error").val('');
		}
		
		function setHeader(title){ 
			header.text(title);
		}
		
		function addReestr(){
			refresh('#reestrfrm');
			
			reestrWnd.dialog("open");
		}
		
		function editReestr(){
			refresh('#reestrfrm');
			
			var reestr = selReestr();
			reestrWnd.dialog("open");
			
			for (p in reestr)
			{
				reestrFrm.find('[name=' + p + ']').val(reestr[p]);
			}
			
			// book
			var gd = reestrFrm.find('select[name=book]').empty().val(''), v;
			gd.trigger("liszt:updated");
			
			if (reestr.bookid)
			{
				v = reestr.bookid;			
				gd.append($("<option></option>").attr("value", v).text(reestr.bookName));
			}
			gd.val(v);
			gd.trigger("liszt:updated");
			
			// reader
			gd = reestrFrm.find('select[name=reader]').empty().val(''), v;
			gd.trigger("liszt:updated");
			
			if (reestr.readerid)
			{
				v = reestr.readerid;			
				gd.append($("<option></option>").attr("value", v).text(reestr.readerFio));
			}
			gd.val(v);
			gd.trigger("liszt:updated");
		}
		
		function deleteReestr(){
			var book = selReestr();			
	
			$.showMessageBox({
				title : 'Внимание',
				content: 'Удалить запись ?',
				type: 'question',			
				OkButtonText: 'Да',
				CloseButtonText: 'Нет',
				OkButtonDoneFunction: function(){ 
					$.ajax({				
						url: 'reestr/delete',				
						data: { id : book.id },
						success: function(data, status){
							(data.success) ? reestrGrid.jqGrid('delRowData', reestr.id) : $.showMessageBox({ title: "Внимание", content: data.message, type: 'alert' });					
						},
						error: function(data, status){
							console.log('err');
						} 
					})
				}	
			});	
			
		}		
		
		function selReestr() {
			
			var rowid = reestrGrid.jqGrid('getGridParam', 'selrow'),
				row = reestrGrid.jqGrid('getRowData', rowid);
			
			row.id = rowid;					
				
			return row;
		}
		
		function saveReestr(){
			var reestr = getValues('#reestrfrm'),
			 	upd = (reestr.id != undefined);
			
			var gd = reestrFrm.find('select[name=book]');
			reestr.bookName = gd.text();
			reestr.bookid = gd.val();
			
			delete reestr.book;
			
			gd = reestrFrm.find('select[name=reader]');
			reestr.readerFio = gd.text();
			reestr.readerid = gd.val();
			
			delete reestr.reader;
			
			reestrWnd.mask("Сохранение");						
			$.ajax({				
				dataType: 'json',
				contentType: 'application/json',
				type: 'post',
				url: 'reestr/update',				
				data: JSON.stringify(reestr),
				success: function(data, status){
					reestrWnd.unmask();
					reestrWnd.dialog("close");	
					
					if (data.success)
					{					
						if (!upd)
							reestr.id = data.id;
						
						upd ? reestrGrid.jqGrid('setRowData', reestr.id, reestr) : reestrGrid.jqGrid('addRowData', reestr.id, reestr, 'last');		
						reestrGrid.trigger("reloadGrid");
					}
				},
				error: function(data, status){
					$.showMessageBox({ title: 'Ошибка', content: 'The requested resource is not available.', type: 'stop' });								
					reestrWnd.unmask();
				} 
			})	
		}
		
		function initReestrGrid(w, h){
			reestrGrid = $('#reestrtable');
			
			reestrGrid.jqGrid({ 
				datatype: 'json', 
				url: 'reestr/getall?' + $.now(),			
				height: h,
				width: w,			
				ignoreCase: true,
				loadonce: true,
				pager: '#reestrpager',
				rowList: [30, 50, 100],
				rowNum: 30,			
				rownumbers: true,
				sortable: true,
				sortname: 'bookName',
				sortorder: 'asc',
				viewrecords: true,
				colNames: [ 'Книга', 'Читатель', 'Дата выдачи', 'Дата возврата', '', ''],
				colModel: [ { name: 'bookName', index: 'bookName', width: 200 }, 
					      	{ name: 'readerFio', index: 'readerFio', width: 200 }, 
					        { name: 'startDate', index: 'startDate', width: 200, sorttype: 'date', align: "right", formatter: 'date', formatoptions: { srcformat:'d.m.Y', newformat:'d.m.Y' } }, 
					        { name: 'endDate', index: 'endDate', width: 200, sorttype: 'date', align: "right", formatter: 'date', formatoptions: { srcformat:'d.m.Y', newformat:'d.m.Y' } },
					        { name: 'bookid', index: 'bookid', width: 100, hidden: true },
					        { name: 'readerid', index: 'readerid', width: 100, hidden: true }],				
				ondblClickRow: function(){ editReestr(); },			
				onSelectRow: function(rowid){ doEdit(true); }			
			}).navGrid('#reestrpager', { edit: false, add: false, del: false });
		}
		
		function addReader(){
			refresh('#readerfrm');
			
			readerWnd.dialog("open");
		}
		
		function editReader(){
			refresh('readerfrm');
			
			var reader = selReader();
			readerWnd.dialog("open");
			
			for (p in reader)
			{
				readerFrm.find('[name=' + p + ']').val(reader[p]);
			}
		}
		
		function deleteReader(){
			var reader = selReader();			
	
			$.showMessageBox({
				title : 'Внимание',
				content: 'Удалить читателя ' + " <b>" + reader.fio + '</b>?',
				type: 'question',			
				OkButtonText: 'Да',
				CloseButtonText: 'Нет',
				OkButtonDoneFunction: function(){ 
					$.ajax({				
						url: 'reader/delete',				
						data: { id : subj.id },
						success: function(data, status){
							(data.success) ? readerGrid.jqGrid('delRowData', reader.id) : $.showMessageBox({ title: "Внимание", content: data.message, type: 'alert' });					
						},
						error: function(data, status){
							console.log('err');
						} 
					})
				}	
			});	
			
		}
		
		
		function selReader() {
			
			var rowid = readerGrid.jqGrid('getGridParam', 'selrow'),
				row = readerGrid.jqGrid('getRowData', rowid);
			
			row.id = rowid;
			row.fio = row.lastname + ' ' + row.firstname;		
			row.middlename && (row.fio += ' ' + row.middlename);		
				
			return row;
		}
		
		function saveReader(){
			var reader = getValues('#readerfrm'),
			 	upd = (reader.id != undefined);
			
			
			readerWnd.mask("Сохранение");						
			$.ajax({				
				dataType: 'json',
				contentType: 'application/json',
				type: 'post',
				url: 'reader/update',				
				data: JSON.stringify(reader),
				success: function(data, status){
					readerWnd.unmask();
					readerWnd.dialog("close");	
					
					if (data.success)
					{					
						if (!upd)
							reader.id = data.id;
						
						upd ? readerGrid.jqGrid('setRowData', reader.id, reader) : readerGrid.jqGrid('addRowData', reader.id, reader, 'last');		
						readerGrid.trigger("reloadGrid");
					}
				},
				error: function(data, status){
					$.showMessageBox({ title: 'Ошибка', content: 'The requested resource is not available.', type: 'stop' });								
					readerWnd.unmask();
				} 
			})	
		}
		
		function initReaderGrid(w, h){
			readerGrid = $('#readertable');
			
			readerGrid.jqGrid({ 
				datatype: 'local', 
				url: 'reader/getall?' + $.now(),			
				height: h,
				width: w,			
				ignoreCase: true,
				loadonce: true,
				pager: '#readerpager',
				rowList: [30, 50, 100],
				rowNum: 30,			
				rownumbers: true,
				sortable: true,
				sortname: 'firstname',
				sortorder: 'asc',
				viewrecords: true,
				colNames: [ 'Фамилия', 'Имя', 'Отчество', 'Дата рождения'],
				colModel: [ { name: 'lastname', index: 'lastname', width: 200 }, 
					      	{ name: 'firstname', index: 'firstname', width: 200 }, 
					      	{ name: 'middlename', index: 'middlename', width: 200 },
					      	{ name: 'birthday', index: 'birthday', width: 200, sorttype: 'date', align: "right", formatter: 'date', formatoptions: { srcformat:'d.m.Y', newformat:'d.m.Y' } } ],				
				ondblClickRow: function(){ editReader(); },			
				onSelectRow: function(rowid){ doEdit(true); }		
			}).navGrid('#readerpager', { edit: false, add: false, del: false });
		}
		
		function addBook(){
			refresh('#bookfrm');
			
			bookWnd.dialog("open");
		}
		
		function editBook(){
			refresh('#bookfrm');
			
			var book = selBook();
			bookWnd.dialog("open");
			
			for (p in book)
			{
				bookFrm.find('[name=' + p + ']').val(book[p]);
			}
			
			// subject
			var gd =  bookFrm.find('select[name=subject]').empty().val(''), v;
			gd.trigger("liszt:updated");
			
			if (book.subjectid)
			{
				v = book.subjectid;			
				gd.append($("<option></option>").attr("value", v).text(book.subjectName));
			}
			gd.val(v);
			gd.trigger("liszt:updated");
		}
		
		function deleteBook(){
			var book = selBook();			
	
			$.showMessageBox({
				title : 'Внимание',
				content: 'Удалить книгу ' + " <b>" + book.name + '</b>?',
				type: 'question',			
				OkButtonText: 'Да',
				CloseButtonText: 'Нет',
				OkButtonDoneFunction: function(){ 
					$.ajax({				
						url: 'book/delete',				
						data: { id : book.id },
						success: function(data, status){
							(data.success) ? bookGrid.jqGrid('delRowData', book.id) : $.showMessageBox({ title: "Внимание", content: data.message, type: 'alert' });					
						},
						error: function(data, status){
							console.log('err');
						} 
					})
				}	
			});	
			
		}		
		
		function selBook() {
			
			var rowid = bookGrid.jqGrid('getGridParam', 'selrow'),
				row = bookGrid.jqGrid('getRowData', rowid);
			
			row.id = rowid;					
				
			return row;
		}
		
		function saveBook(){
			var book = getValues('#bookfrm'),
			 	upd = (book.id != undefined);
			
			var gd = bookFrm.find('select[name=subject]');
			book.subjectName = gd.text();
			book.subjectid = gd.val();
			
			bookWnd.mask("Сохранение");						
			$.ajax({				
				dataType: 'json',
				contentType: 'application/json',
				type: 'post',
				url: 'book/update',				
				data: JSON.stringify(book),
				success: function(data, status){
					bookWnd.unmask();
					bookWnd.dialog("close");	
					
					if (data.success)
					{					
						if (!upd)
							book.id = data.id;
						
						upd ? bookGrid.jqGrid('setRowData', book.id, book) : bookGrid.jqGrid('addRowData', book.id, reader, 'last');		
						bookGrid.trigger("reloadGrid");
					}
				},
				error: function(data, status){
					$.showMessageBox({ title: 'Ошибка', content: 'The requested resource is not available.', type: 'stop' });								
					bookWnd.unmask();
				} 
			})	
		}
		
		function initBookGrid(w, h){
			bookGrid = $('#booktable');
			
			bookGrid.jqGrid({ 
				datatype: 'local', 
				url: 'book/getall?' + $.now(),			
				height: h,
				width: w,			
				ignoreCase: true,
				loadonce: true,
				pager: '#subjpager',
				rowList: [30, 50, 100],
				rowNum: 30,			
				rownumbers: true,
				sortable: true,
				sortname: 'name',
				sortorder: 'asc',
				viewrecords: true,
				colNames: [ 'Наименование', 'Автор', 'Тематика', 'Издательство', 'Год выпуска', ''],
				colModel: [ { name: 'name', index: 'name', width: 200 }, 
					      	{ name: 'author', index: 'author', width: 200 },
					      	{ name: 'subjectName', index: 'subjectName', width: 200 },
					      	{ name: 'publish', index: 'publish', width: 200 },
					      	{ name: 'year', index: 'year', width: 100, align: 'right', sorttype: 'int' },
					      	{ name: 'subjectid', index: 'subjectid', width: 100, hidden: true }],				
				ondblClickRow: function(){ editBook(); },			
				onSelectRow: function(rowid){ doEdit(true); }			
			}).navGrid('#subjpager', { edit: false, add: false, del: false });
		}
		
		function addSubj(){
			refresh('#subjfrm');
			
			subjWnd.dialog("open");
		}
		
		function editSubj(){
			refresh('subjfrm');
			
			var subj = selSubj();
			subjWnd.dialog("open");
			
			for (p in subj)
			{
				subjFrm.find('[name=' + p + ']').val(subj[p]);
			}
		}
		
		function deleteSubj(){
			var subj = selSubj();			
	
			$.showMessageBox({
				title : 'Внимание',
				content: 'Удалить тематику (с книгами) ' + " <b>" + subj.name + '</b>?',
				type: 'question',			
				OkButtonText: 'Да',
				CloseButtonText: 'Нет',
				OkButtonDoneFunction: function(){ 
					$.ajax({				
						url: 'subject/delete',				
						data: { id : subj.id },
						success: function(data, status){
							(data.success) ? subjGrid.jqGrid('delRowData', subj.id) : $.showMessageBox({ title: "Внимание", content: data.message, type: 'alert' });					
						},
						error: function(data, status){
							console.log('err');
						} 
					})
				}	
			});				
		}		
		
		function selSubj() {
			
			var rowid = subjGrid.jqGrid('getGridParam', 'selrow'),
				row = subjGrid.jqGrid('getRowData', rowid);
			
			row.id = rowid;			
				
			return row;
		}
		
		function saveSubj(){
			var subj = getValues('#subjfrm'),
			 	upd = (subj.id != undefined);
			
			
			subjWnd.mask("Сохранение");						
			$.ajax({				
				dataType: 'json',
				contentType: 'application/json',
				type: 'post',
				url: 'subject/update',				
				data: JSON.stringify(subj),
				success: function(data, status){
					subjWnd.unmask();
					subjWnd.dialog("close");	
					
					if (data.success)
					{					
						if (!upd)
							subj.id = data.id;
						
						upd ? subjGrid.jqGrid('setRowData', subj.id, subj) : subjGrid.jqGrid('addRowData', subj.id, subj, 'last');		
						subjGrid.trigger("reloadGrid");
					}
				},
				error: function(data, status){
					$.showMessageBox({ title: 'Ошибка', content: 'The requested resource is not available.', type: 'stop' });								
					subjWnd.unmask();
				} 
			})	
		}
		
		function initSubjGrid(w, h){
			subjGrid = $('#subjtable');
			
			subjGrid.jqGrid({ 
				datatype: 'local', 
				url: 'subject/getall?' + $.now(),			
				height: h,
				width: w,			
				ignoreCase: true,
				loadonce: true,
				pager: '#subjpager',
				rowList: [30, 50, 100],
				rowNum: 30,			
				rownumbers: true,
				sortable: true,
				sortname: 'name',
				sortorder: 'asc',
				viewrecords: true,
				colNames: [ 'Наименование'],
				colModel: [ { name: 'name', index: 'name', width: 500 } ],				
				ondblClickRow: function(){ editSubj(); },			
				onSelectRow: function(rowid){ doEdit(true); }			
			}).navGrid('#subjpager', { edit: false, add: false, del: false });
		}
		
		function addUser(){
			refresh('#usrfrm');
			
			usrFrm.find(".psw legend").hide();
			usrFrm.find("#showpasswd").removeAttr("checked");
			usrWnd.dialog("open");
		}
		
		function editUser(){
			refresh('usrfrm');
			
			var usr = selUser();
			
			usrFrm.find(".psw legend").show();
			usrFrm.find("#showpasswd").removeAttr("checked");
			usrWnd.dialog("open");
			
			for (p in usr)
			{
				usrFrm.find('[name=' + p + ']').val(usr[p]);
			}
			
			if (usr.isAdmin == 1)
				usrFrm.find('[name=isadmin]').prop('checked', true);
			else
				usrFrm.find('[name=isadmin]').removeAttr('checked');
		}
		
		function deleteUser(){
			var usr = selUser();			
	
			$.showMessageBox({
				title : 'Внимание',
				content: 'Удалить пользователя ' + " <b>" + usr.fio + '</b>?',
				type: 'question',			
				OkButtonText: 'Да',
				CloseButtonText: 'Нет',
				OkButtonDoneFunction: function(){ 
					$.ajax({				
						url: 'person/delete',				
						data: { id : usr.id },
						success: function(data, status){
							(data.success) ? usrGrid.jqGrid('delRowData', usr.id) : $.showMessageBox({ title: "Внимание", content: data.message, type: 'alert' });					
						},
						error: function(data, status){
							console.log('err');
						} 
					})
				}	
			});	
			
		}
		
		function selUser() {
		
			var rowid = usrGrid.jqGrid('getGridParam', 'selrow'),
				row = usrGrid.jqGrid('getRowData', rowid);
			
			row.id = rowid;
			row.fio = row.lastname + ' ' + row.firstname;		
			row.middlename && (row.fio += ' ' + row.middlename);
				
			return row;
		}
		
		function saveUser(){
			var usr = getValues('#usrfrm'),
			 	upd = (usr.id != undefined);
			delete usr['passwd-clone'];
			
			usrWnd.mask("Сохранение");						
			$.ajax({				
				dataType: 'json',
				contentType: 'application/json',
				type: 'post',
				url: 'person/update',				
				data: JSON.stringify(usr),
				success: function(data, status){
					usrWnd.unmask();
					usrWnd.dialog("close");	
					
					if (data.success)
					{					
						if (!upd)
							usr.id = data.id;
						
						upd ? usrGrid.jqGrid('setRowData', usr.id, usr) : usrGrid.jqGrid('addRowData', usr.id, usr, 'last');		
						usrGrid.trigger("reloadGrid");
					}
				},
				error: function(data, status){
					$.showMessageBox({ title: 'Ошибка', content: 'The requested resource is not available.', type: 'stop' });								
					usrWnd.unmask();
				} 
			})	
		}
		
		function initUsrGrid(w, h){
			usrGrid = $('#usrtable');
			
			usrGrid.jqGrid({ 
				datatype: 'local', 
				url: 'person/getall?' + $.now(),			
				height: h,
				width: w,			
				ignoreCase: true,
				loadonce: true,
				pager: '#usrpager',
				rowList: [30, 50, 100],
				rowNum: 30,			
				rownumbers: true,
				sortable: true,
				sortname: 'login',
				sortorder: 'asc',
				viewrecords: true,
				colNames: [ 'Логин', 'Фамилия', 'Имя', 'Отчество', 'Администратор'],
				colModel: [ { name: 'login', index: 'login', width: 200, frozen: true }, 
					      	{ name: 'lastname', index: 'lastname', width: 200 }, 
					        { name: 'firstname', index: 'firstname', width: 200 }, 
					        { name: 'middlename', index: 'middlename', width: 200 },
					        { name: 'isAdmin', index: 'isAdmin', align: 'center', width: 120, editoptions: { value: '1:0' }, formatter: "checkbox", formatoptions: { disabled: true } } ],
				ondblClickRow: function(){ editUser(); },			
				onSelectRow: function(rowid){ doEdit(true); }			
			}).navGrid('#usrpager', { edit: false, add: false, del: false });
	
		}
	
		$(function(){
			$("#reestrbtn").button({
				icons: { primary: "ui-icon-link" }
			})
			.click(function() {
				activePane = 0;
				
				activatePane("reestrgrid");
				setHeader($(this).text());
				doEdit(false);
			});
			
			$("#readerbtn").button({
				icons: { primary: "ui-icon-person" }
			})
			.click(function() {
				activePane = 1;
				
				if (!$(this).attr("loaded"))
				{		
					readerGrid.setGridParam({ 
						datatype: 'json', 
						loadComplete: function(){ $('#readerbtn').attr('loaded', true); $(this).setGridParam({ loadComplete: null }); } 
					}).trigger('reloadGrid', [{ page: 1 }]);
				}
				
				activatePane("readergrid");
				setHeader($(this).text());
				doEdit(false);
			});;
			
			$("#bookbtn").button({
				icons: { primary: "ui-icon-note" }
			})
			.click(function() {
				activePane = 2;
				
				if (!$(this).attr("loaded"))
				{		
					bookGrid.setGridParam({ 
						datatype: 'json', 
						loadComplete: function(){ $('#bookbtn').attr('loaded', true); $(this).setGridParam({ loadComplete: null }); } 
					}).trigger('reloadGrid', [{ page: 1 }]);
				}
				
				activatePane("bookgrid");
				setHeader($(this).text());
				doEdit(false);
			});;
			
			$("#subjectbtn").button({
				icons: { primary: "ui-icon-folder-open" }
			})
			.click(function() {
				activePane = 3;
				
				if (!$(this).attr("loaded"))
				{		
					subjGrid.setGridParam({ 
						datatype: 'json', 
						loadComplete: function(){ $('#subjbtn').attr('loaded', true); $(this).setGridParam({ loadComplete: null }); } 
					}).trigger('reloadGrid', [{ page: 1 }]);
				}
				
				activatePane("subjgrid");
				setHeader($(this).text());
				doEdit(false);
			});;
			
			$("#usrbtn").button({
				icons: { primary: "ui-icon-person" }
			})
			.click(function() {
				activePane = 4;
				
				if (!$(this).attr("loaded"))
				{		
					usrGrid.setGridParam({ 
						datatype: 'json', 
						loadComplete: function(){ $('#usrbtn').attr('loaded', true); $(this).setGridParam({ loadComplete: null }); } 
					}).trigger('reloadGrid', [{ page: 1 }]);
				}
				
				activatePane("usrgrid");
				setHeader($(this).text());
				doEdit(false);
			});
			
			$("#addbtn").button({ 
				icons: { primary: "ui-icon-plusthick" },
				text: false
			})
			.click(function(){
				switch (activePane)
				{
					case 0:
						addReestr();
						break;
					case 1:
						addReader();
						break;
					case 2:
						addBook();
						break;
					case 3:
						addSubj();
						break;
					case 4:
						addUser();
						break;
				}
			});
			
			btnEdit = $("#editbtn").button({ 
				icons: { primary: "ui-icon-pencil" },
				disabled: true,
				text: false
			})
			.click(function(){
				switch (activePane)
				{
					case 0:
						editReestr();
						break;
					case 1:
						editReader();
						break;
					case 2:
						editBook();
						break;
					case 3:
						editSubj();
						break;
					case 4:
						editUser();
						break;
				}
			});
			
			btnRemove = $("#removebtn").button({ 
				icons: { primary: "ui-icon-trash" },
				disabled: true,
				text: false
			})
			.click(function(){
				switch (activePane)
				{
					case 0:
						deleteReestr();
						break;
					case 1:
						deleteReader();
						break;
					case 2:
						deleteBook();
						break;
					case 3:
						deleteSubj();
						break;
					case 4:
						deleteUser();
						break;
				}
			});
			
			$("#loginbtn").button({ 
				icons: { primary: "ui-icon-locked" }				
			})
			.click(function(){				
				window.location = '<c:choose><c:when test="${logged == 0}"><c:url value="login" /></c:when><c:otherwise><c:url value="j_spring_security_logout" /></c:otherwise></c:choose>';	
			});
			
			var $Container = $('#container');
			
			$Container.height($(window).height() - $Container.offset().top - 12);			
			$Container.layout({ west: { size: 262, spacing_closed: 21, fxName: "drop", fxSpeed: "normal", fxSettings: { easing: "" } } });
			
			header = $("#accordion > h3");
			
			var h = $('.ui-layout-west').height() - 60;
				w = window.innerWidth - $('.ui-layout-west').width() - 30;
			
			initReestrGrid(w, h);
			initReaderGrid(w, h);
			initBookGrid(w, h);
			initSubjGrid(w, h);			
			initUsrGrid(w, h);
			
			var menu = $('#addmenu').menu();
			
			menu.find("li.additem").click(function(){				
				switch (activePane)
				{
					case 0:
						addReestr();
						break;
					case 1:
						addReader();
						break;
					case 2:
						addBook();
						break;
					case 3:
						addSubj();
						break;
					case 4:
						addUser();
						break;
				}				
			});
			
			menu.find("li.edititem").click(function(){				
				switch (activePane)
				{
					case 0:
						editReestr();
						break;
					case 1:
						editReader();
						break;
					case 2:
						editBook();
						break;
					case 3:
						editSubj();
						break;
					case 4:
						editUser();
						break;
				}				
			});
			
			menu.find("li.removeitem").click(function(){				
				switch (activePane)
				{
					case 0:
						deleteReestr();
						break;
					case 1:
						deleteReader();
						break;
					case 2:
						deleteBook();
						break;
					case 3:
						deleteSubj();
						break;
					case 4:
						deleteUser();
						break;
				}				
			});
			
			$('#reestrtable, #readertable, #booktable, #subjtable, #usrtable').delegate('tr.jqgrow', 'contextmenu', function (e){
				e.preventDefault();
				
				var rowid = $(this).attr('id');
				
				if (rowid){
					menu.css({ 'left': e.pageX, 'top': e.pageY }).show();
					$(document).one("click", function() {
						menu.hide();
					});		
				}
			});	
			
			reestrWnd = $("#reestrwnd").dialog({ autoOpen: false, height: 360, width: 440, modal: true,
				buttons: {
					"Сохранить": function() {
						saveReestr();					 
					},
					"Отмена": function() {
						$(this).dialog("close");
					}
				}					 	
			});
			reestrFrm = reestrWnd.find("#reestrfrm");
			
			reestrFrm.find('select[name=book]').chosen({ title: 'Книги', api: { read: "book/getbooks" }, autoReload: true, minChars: 3, onechoice: true, struct: false });
			reestrFrm.find('select[name=reader]').chosen({ title: 'Читатели', api: { read: "reader/getreaders" }, autoReload: true, minChars: 3, onechoice: true, struct: false });
			
			reestrFrm.find('[name=startDate]').datepicker({ dateFormat: 'dd.mm.yy' });
			reestrFrm.find('[name=endDate]').datepicker({ dateFormat: 'dd.mm.yy' });
			
			bookWnd = $("#bookwnd").dialog({ autoOpen: false, height: 400, width: 440, modal: true,
				buttons: {
					"Сохранить": function() {
						saveBook();					 
					},
					"Отмена": function() {
						$(this).dialog("close");
					}
				}					 	
			});
			bookFrm = bookWnd.find("#bookfrm");
			bookFrm.find('select[name=subject]').chosen({ title: 'Тематики', api: { read: "subject/getsubjects" }, autoReload: true, minChars: 3, onechoice: true, struct: false });			
			
			readerWnd = $("#readerwnd").dialog({ autoOpen: false, height: 360, width: 440, modal: true,
				buttons: {
					"Сохранить": function() {
						saveReader();					 
					},
					"Отмена": function() {
						$(this).dialog("close");
					}
				}					 	
			});
			readerFrm = readerWnd.find("#readerfrm");
			readerFrm.find('[name=birthday]').datepicker({ dateFormat: 'dd.mm.yy' });
			
			subjWnd = $("#subjwnd").dialog({ autoOpen: false, height: 320, width: 440, modal: true,
				buttons: {
					"Сохранить": function() {
						saveSubj();					 
					},
					"Отмена": function() {
						$(this).dialog("close");
					}
				}	 	
			});
			subjFrm = subjWnd.find("#subjfrm");
			
			usrWnd = $("#usrwnd").dialog({ autoOpen: false, height: 480, width: 440, modal: true,
				buttons: {
					"Сохранить": function() {
						saveUser();					 
					},
					"Отмена": function() {
						$(this).dialog("close");
					}
				}					 	
			});
			usrFrm = usrWnd.find("#usrfrm");		
			
    	});
	</script>	
</head>
<body>
	<div id="mainbar" class="ui-widget-header">
		<span class="ui-buttonset">
			<button id="reestrbtn">Реестр</button>
    		<button id="readerbtn">Читатели</button>    		
    		<button id="bookbtn">Книги</button>
    		<button id="subjectbtn">Тематики</button>
    		<sec:authorize access="hasRole('ROLE_ADMIN')">	
    		<button id="usrbtn">Пользователи</button>    	
    		</sec:authorize>	
    		<button id="loginbtn">
   			<c:choose>
				<c:when test="${logged == 0}">
					Войти
				</c:when>
				<c:otherwise>
					Выйти
				</c:otherwise>
			</c:choose>
			</button>
			<span id="info">${pageContext.request.userPrincipal.name}</span>
    	</span>    	    	    	
	</div>
	<div id="container">
		<div id="accordion" class="ui-layout-west" style="overflow: hidden">
			<h3>Реестр</h3>
			<c:if test="${logged == 1}">
			<div>					
				<button id="addbtn">Добавить</button>
				<button id="removebtn">Удалить</button>
				<button id="editbtn">Изменить</button>				
			</div>
			</c:if>
		</div>
		<div class="ui-layout-center">
			<div id="reestrgrid" style="width:100%">
				<table id="reestrtable"></table>
				<div id="reestrpager"></div>
			</div>
			<div id="readergrid" class="ui-helper-hidden">
				<table id="readertable"></table>
				<div id="readerpager"></div>
			</div>		
			<div id="bookgrid" class="ui-helper-hidden">
				<table id="booktable"></table>
				<div id="bookpager"></div>
			</div>			
			<div id="subjgrid" class="ui-helper-hidden">
				<table id="subjtable"></table>
				<div id="subjpager"></div>
			</div>
			<sec:authorize access="hasRole('ROLE_ADMIN')">	
			<div id="usrgrid" class="ui-helper-hidden">		
				<table id="usrtable"></table>
				<div id="usrpager"></div>
			</div>		
			</sec:authorize>
		</div>		
	</div>
	<ul id="addmenu" >
		<li class="additem"><a href="#"><span class="ui-icon ui-icon-plusthick"></span>Добавить</a></li>						
		<li class="edititem"><a href="#"><span class="ui-icon ui-icon-pencil"></span>Изменить</a></li>	
		<li class="removeitem"><a href="#"><span class="ui-icon ui-icon-trash"></span>Удалить</a></li>					
	</ul>
	<div id="reestrwnd" class="ui-helper-hidden" title="Реестр">	 	
		<form id="reestrfrm" autocomplete="off">				 			
 			<input name="id" type="hidden"/>
 			<fieldset>
 	    		<label for="book">Книга</label>
 	    		<div>
    				<select name="book" style="width: 280px" class="text" data-placeholder="Книга"></select>
    			</div>	
    			<label for="reader">Читатель</label>
 	    		<div>
    				<select name="reader" style="width: 280px" class="text" data-placeholder="Читатель"></select>
    			</div>
    			<label for="startDate" style="display: inline-block">Дата выдачи</label>
        		<input name="startDate" type="text"  class="text"/>   
				<label for="endtDate" style="display: inline-block">Дата возврата</label>
        		<input name="endDate" type="text"  class="text"/>      
     		</fieldset>
   		</form>    	
	</div>
	<div id="bookwnd" class="ui-helper-hidden" title="Книга">	 	
		<form id="bookfrm" autocomplete="off">				 			
 			<input name="id" type="hidden"/>
 			<fieldset>
     			<label for="name" style="margin-top: 12px">Наименование</label>
     			<input name="name" type="text" style="width: 95%" class="text" />
     			<label for="author">Автор</label>
     			<input name="author" type="text" style="width: 95%" class="text" />
 	    		<label for="publish" style="display: inline-block">Издательство</label>
        		<input name="publish" type="text"  class="text"/>
 	    		<label for="subject">Тематика</label>
 	    		<div>
    				<select name="subject" style="width: 280px" class="text" data-placeholder="Тематика"></select>
    			</div>	
    			<label for="yearh" style="display: inline-block">Год выпуска</label>        
      			<input name="year" type="text"  class="text"/>
     		</fieldset>
   		</form>    	
	</div>
	<div id="readerwnd" class="ui-helper-hidden" title="Читатель">	 	
		<form id="readerfrm" autocomplete="off">				 			
 			<input name="id" type="hidden"/>
 			<fieldset>
     			<label for="lastname" style="margin-top: 12px">Фамилия</label>
     			<input name="lastname" type="text" style="width: 95%" class="text" />
     			<label for="firstname">Имя</label>
     			<input name="firstname" type="text" style="width: 95%" class="text" />
 	    		<label for="middlename">Отчество</label>
      			<input name="middlename" type="text" style="width: 95%" class="text" />
      			<label for="birthday" style="display: inline-block">Дата рождения</label>
        		<input name="birthday" type="text"  class="text"/>        		     			
     		</fieldset>
   		</form>    	
	</div>
	<div id="subjwnd" class="ui-helper-hidden" title="Тематика">
	 	<form id="subjfrm">
    		<input name="id" type="hidden"/>
    		<fieldset>    						         	
        		<label for="name">Название</label>
        		<textarea name="name" style="width: 95%" class="text"></textarea>        	
    		</fieldset>
    	</form>		
	</div>		
	<div id="usrwnd" class="ui-helper-hidden" title="Пользователь">	 	
		<form id="usrfrm" autocomplete="off">				 			
 			<input name="id" type="hidden"/>
 			<fieldset>
					<label for="login">Логин</label>
					<input name="login" type="text" style="width: 45%" class="text" />
     			<fieldset class="psw ui-corner-all ui-state-default" style="clear: left; margin-left: -6px">
     				<legend>Если вы не хотите менять пароль, оставьте поле пустым</legend>
     			<ol>
     					<li>
     						<label for="password">Пароль</label>
     						<input name="password" type="password" style="width: 90%" class="text" data-typetoggle="#showpasswd" />
     					</li>
     					<li style="padding-top: 18px">        							
     						<input id="showpasswd" type="checkbox" style="display:inline-block;margin-left: 24px" />
     						Показать пароль
     					</li>
     				</ol>
     			</fieldset>
     			<label for="lastname" style="margin-top: 12px">Фамилия</label>
     			<input name="lastname" type="text" style="width: 95%" class="text" />
     			<label for="firstname">Имя</label>
     			<input name="firstname" type="text" style="width: 95%" class="text" />
 	    		<label for="middlename">Отчество</label>
      			<input name="middlename" type="text" style="width: 95%" class="text" />
      			<label for="locked" style="display: inline-block">Администратор</label>
        		<input type="checkbox" name="isAdmin" style="display: inline-block" value="1" />        		     			
     		</fieldset>
   		</form>    	
	</div>	
</body>
</html>