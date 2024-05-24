<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Blog</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="./assets/css/editProduct.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div class="modal">
    <div class="modal-container">
        <form action="editBlog" method="post" enctype="multipart/form-data">
            <div class="modal-header">
                <p>Edit Blog</p>
            </div>

            <div class="modal-body">
                <div class="row1">
                    <div class="row1_col1">
                        <label class="modal-label">ID</label>
                        <input value="${detail.id}" name="id" type="text" class="modal-input" readonly required></input>
                    </div>
                    
                    <div class="div1">
                    <label class="modal-label">Image</label>
                    <div class="hero" style="align-items: center; 
                    /* width: 150px; 
                    height: 150px; */
                    justify-content: center;">
                        <div class="card">
                            <label for="input-file" class="css-label-img"
                            >Upload image</label>
                            <img src="${detail.image}" id="profile" style="width: 100px; height: 100px;">
                            <input  type="file" accept="image/jpeg, image/png, image/jpg" name="image" id="input-file" style="display: none;" />
                            <input value="${detail.image}" name="images" type="hidden">
                        </div>
                    </div>
                </div>

                    <div class="row1_col1">
                        <label class="modal-label">Title</label>
                        <textarea name="title" id="title" cols="40" rows="4"
                                  class="modal-textarea1" required>${detail.title}</textarea>
                    </div>

                    <div class="row1_col1">
                        <label class="modal-label">Description</label>
                        <textarea name="description" id="description" cols="40" rows="4"
                                  class="modal-textarea" required>${detail.description}</textarea>
                    </div>

                </div>

                <div class="modal-footer" style="margin-left: -200px;">
                    <input type="submit" id="input-add" value="Edit"/>
                </div>
        </form>
    </div>
</div>
</body>
<script>
        let profilePic = document.getElementById("profile")
        let inputFile = document.getElementById("input-file");

        inputFile.onchange = function () {
            profilePic.src = URL.createObjectURL(inputFile.files[0]);
        }
</script>
</html>