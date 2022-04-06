function list(){
	$.ajax({
		type : "post",
		url : "/title/list",
		success : function(response) {
			$("#titleTable").bootstrapTable('load',response);
			$("#titleTable tbody").on('click','tr',function() {
				$("#title_no").val($(this).find("td:eq(0)").text());
				$("#title").val($(this).find("td:eq(1)").text());
				$("#btn_group_old").show();
				$("#btn_group_new").hide();
				$("#myModal").modal("show");

			});
		}
	});
}

function select(){
	$.ajax({
		type : "post",
		url : "/title/select",
		data: "title_no=" + $("#title_no").val(),
		success : function(response) {
			$("#title").val(response.title);
		}
	});
}

function del(){
	$.ajax({
		type : "post",
		url : "/title/delete",
		data: "title_no=" + $("#title_no").val(),
		success : function(response) {
			if (response == 1) {
				alert("Se eliminó el registro");
				list();
				$("#myModal").modal("hide");

			}			
		}
	});
}

function update(){
	$.ajax({
		type : "post",
		url : "/title/update",
		data: {
			dept_no:$("#title_no").val(),
			dept_name:$("#title").val()
			},
		success : function(response) {
			if (response == 1) {
				alert("Se actualizó el registro");
				list();
				$("#myModal").modal("hide");
			}			
		}
	});
}

function add() {
	$("#title_no").val("");
	$("#title").val("");
	$("#myModal").modal("show");
	$("#btn_group_old").hide();
	$("#btn_group_new").show();
}


function insert(){
	$.ajax({
		type : "post",
		url : "/title/insert",
		data: {
			title_no:$("#title_no").val(),
			title:$("#title").val()
			},
		success : function(response) {
			if (response == 1) {
				alert("Se insertó el registro");
				list();
				$("#myModal").modal("hide");
			}			
		}
	});
}
