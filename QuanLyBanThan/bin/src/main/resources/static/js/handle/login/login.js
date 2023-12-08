$(document).ready(function () {

	$('#btnSubmit').unbind().bind('click', function(e){
		if(validate){
			var url = "/login";
			debugger;
		var loginData = {
            username: $('#loginName').val(),
            password: $('#loginPassword').val(),
        };

		$.ajax({
            type: "POST", // Phương thức HTTP (có thể là GET, POST, PUT, DELETE, vv.)
            url: url, // Đường dẫn đến điểm cuối máy chủ của bạn
            data: JSON.stringify(loginData), // Chuyển đổi dữ liệu thành chuỗi JSON
            contentType: "application/json", // Định dạng của dữ liệu gửi đi
            success: function (response) {
                // Xử lý phản hồi từ máy chủ nếu cần
                alert('Thanfh coong');
            },
            error: function () {
                $("#result").text("An error occurred.");
                alert('Thats bai')
            }
        });
        
        
		}
	});

});

function validate() {
	return true;
}