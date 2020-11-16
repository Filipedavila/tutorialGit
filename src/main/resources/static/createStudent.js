async function save() {
    try {
        let data = {
            name: document.getElementById("name").value,
            birthDate: Date.parse(document.getElementById("date").value),
            gender: parseInt(document.getElementsByName("gender").value),

        };
        let res = await $.ajax({
            url: "/api/java/tester/units",
            data: JSON.stringify(data),
            method: "post",
            contentType:"application/json",
            dataType: "json"
        });
        document.getElementById("message").innerHTML = JSON.stringify(res);
    } catch (error) {
        console.log(error);
    }
}