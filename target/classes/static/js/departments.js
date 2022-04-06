function list(){
	$.ajax({
		type : "post",
		url : "/departments/list",
		success : function(response) {
			$("#departmentsTable").bootstrapTable('load',response);
			$("#departmentsTable tbody").on('click','tr',function() {
				$("#dept_no").val($(this).find("td:eq(0)").text());
				$("#dept_name").val($(this).find("td:eq(1)").text());
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
		url : "/departments/select",
		data: "dept_no=" + $("#dept_no").val(),
		success : function(response) {
			$("#dept_name").val(response.dept_name);
		}
	});
}

function del(){
	$.ajax({
		type : "post",
		url : "/departments/delete",
		data: "dept_no=" + $("#dept_no").val(),
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
		url : "/departments/update",
		data: {
			dept_no:$("#dept_no").val(),
			dept_name:$("#dept_name").val()
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
	$("#dept_no").val("");
	$("#dept_name").val("");
	$("#myModal").modal("show");
	$("#btn_group_old").hide();
	$("#btn_group_new").show();
}


function insert(){
	$.ajax({
		type : "post",
		url : "/departments/insert",
		data: {
			dept_no:$("#dept_no").val(),
			dept_name:$("#dept_name").val()
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
