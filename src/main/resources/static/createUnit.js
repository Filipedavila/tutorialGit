async function save() {
    try {
        let data = {
            id: document.getElementById("id").value,
            name: document.getElementById("name").value,
            credits: parseInt(document.getElementById("ects").value)
        };
        let idTest = document.getElementById("id").value;
        let res = await $.ajax({
            url: "/api/java/units/create/"+ idTest,
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
