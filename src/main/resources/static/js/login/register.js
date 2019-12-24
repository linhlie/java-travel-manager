
jQuery('.validate-form').validate({
    rules: {
        password: {
            required: true,
            minlength: 5
        },
        confirmPassword: {
            required: true,
            minlength: 5,
            equalTo: "#password"
        }
    }
});
