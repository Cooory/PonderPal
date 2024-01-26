<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Feed</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="/static/css/style.css" type="text/css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
</head>
<body>

<div id="wrap" class="container">
    <c:import url="/WEB-INF/jsp/include/header.jsp"/>
    <section>
        <input id="postName" class="form-control" placeholder="What is your concern?">

        <div class="line2 d-flex justify-content-between mt-5">
            <select id="voteCategory" class="form-control col-5">
                <option value="">Category</option>
                <option value="a">a</option>
                <option value="b">b</option>
                <option value="c">c</option>
                <option value="d">d</option>
                <option value="e">e<option>
            </select>

            <select id="voteDuration" class="form-control col-5">
                <option value="">Vote duration</option>
                <option value="3">3 hours</option>
                <option value="6">6 hours</option>
                <option value="12">12 hours</option>
                <option value="24">24 hours</option>
                <option value="48">48 hours<option>
            </select>
        </div>

        <div class="d-flex justify-content-center mt-3 mb-3">
            <button type="button" id="addVoteOptionBtn" class="btn" style="background-color: rgb(252, 234, 136">ADD
            </button>
        </div>


        <div class="border rounded">
            <div id="voteOptionArea" class="row">

            </div>
        </div>

        <div>

        </div>


        <div class="d-flex justify-content-center mt-3 mb-3">
            <button type="button" id="createPostBtn" class="btn" style="background-color: rgb(252, 234, 136">UPLOAD
            </button>
        </div>


    </section>

    <c:import url="/WEB-INF/jsp/include/footer.jsp"/>
</div>


<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script>
    // dropdown에서 선택한 숫자만큼의 입력 폼을 동적으로 생성
    /*
        $('#numberOfVoteOption').change(function() {
        var numberOfVoteOption = $(this).val();
        var formFields = '';

        for (var i = 1; i <= numberOfVoteOption; i++) {
        }

        $('#thoughtForms').html(formFields);
        });
    */
    var voteOptionIndex = 0;

    $("#addVoteOptionBtn").click(function () {
        voteOptionIndex++
        $("#voteOptionArea").append(
            '<div id="voteOptionIndex' + voteOptionIndex + '" class="col-3">' +
            '<input type="text" id="voteOptionName' + voteOptionIndex + '" class="form-control" placeholder="Concern ' + voteOptionIndex + '">' +
            '<textarea id="voteOptionDescription' + voteOptionIndex + '"  class="form-control" placeholder="Content ' + voteOptionIndex + '"></textarea>' +
            '<div>' +
            '<input type="file" id="voteOptionFile' + voteOptionIndex + '" class="btn"></input>' +
            '<button type="submit" id="voteOptionDelete' + voteOptionIndex + '"  class="btn btn-danger">고민 삭제</button>' +
            '</div>' +
            '</div>'
        )
    });

    $(document).on("click", "button[id^='voteOptionDelete']", function () {
        var voteOptionIndex = $(this).attr("id").replace("voteOptionDelete", "");
        $("#voteOptionIndex" + voteOptionIndex).remove();
    });

    $("#createPostBtn").on("click", function () {
        let formData = new FormData();

        let postName = $("#postName").val();
        let voteCategory = $("#voteCategory").val();
        let voteDuration = $("#voteDuration").val();

        if (postName == "") {
            alert("Fill your Concern Title");
            return;
        }

        if (voteCategory == "") {
            alert("Fill your Concern Category");
            return;
        }

        if (voteDuration == "") {
            alert("Fill your Concern Duration");
            return;
        }

        let voteOptionData = {
            voteOptions : []
        }

        for (let i = 1; i <= voteOptionIndex; i++) {
            if ($("#voteOptionName" + i).val() === undefined) {
                continue;
            }

            let voteOptionName = $("#voteOptionName" + i).val();
            let voteOptionDescription = $("#voteOptionDescription" + i).val();
            let fileInput = $("#voteOptionFile" + i)[0].files;

            if (voteOptionName == "") {
                alert("Fill your Concern Title");
                return;
            }

            if (voteOptionDescription == "") {
                alert("Fill your Concern Content");
                return;
            }

            voteOptionData.voteOptions.push({
                voteOptionName: voteOptionName,
                voteOptionDescription: voteOptionDescription
            })

            formData.append("file", fileInput[0]);
        }

        formData.append("postName", postName);
        formData.append("voteCategory", voteCategory);
        formData.append("voteDuration", voteDuration);
        formData.append("voteOptionData", JSON.stringify(voteOptionData));

        $.ajax({
            type: "post"
            , url: "/post/create"
            , data: formData
            , enctype: "multipart/form-data"
            , processData: false
            , contentType: false
            , success: function (data) {
                if (data.result == "success") {
                    location.reload();
                } else {
                    alert("글쓰기 실패");
                }
            }
            , error: function () {
                alert("글쓰기 에러");
            }
        });
    });
</script>

</body>
</html>