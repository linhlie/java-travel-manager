// (function ($) {
//     function setButtonClickListenter(id, callback) {
//         $(id).off('click');
//         $(id).click(function () {
//             if (typeof callback === "function") {
//                 callback();
//             }
//         });
//     }
//     function doRegister() {
//         console.log("test")
//
//          var email = $('#email').val();
//          var fullName = $('#fullName').val();
//         var password = $('#password').val();
//         var confirmPassword = $('#confirmPassword').val();
//         var birthday = $('#birthday').val();
//         var phone = $('#phone').val();
//         var imageId = $('#imageId').val();
//        var user = {
//            email :email,
//            fullName:fullName,
//            password:password,
//            confirmPassword:confirmPassword,
//            birthday:birthday,
//            phone:phone,
//            imageId:imageId
//        }
//         JSON.stringify(user)
//         console.log(user.email)
//         function onSuccess(response) {
//             if (response && response.status) {
//                 console.log("Success!")
//             } else {
//                 console.error("[ERROR] dashboard load data failed!");
//             }
//         }
//
//         function onError(error) {
//             console.error("[ERROR] dashboard load data error!", error);
//         }
//         saveUsers(user,onSuccess,onError);
//
//     }
//     $(function () {
//         setButtonClickListenter('#register',doRegister)
//     })
// })(jQuery);