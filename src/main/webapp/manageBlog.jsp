<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Quản lý bài viết</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    <link rel="stylesheet" href="./assets/css/manageBlog.css">
    <link
            href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;1,300;1,400;1,500;1,700&display=swap"
            rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
</head>
<body>
<div class="container">
    <div class="container_header">
        <p>Manage Blog</p>
        <div class="form_add">
            <button class="btn-add" id="myBtn">
                <div class="icon-add"><i class="fa-solid fa-plus"></i></div>
                <span>Add New Blog</span>
            </button>
        </div>
    </div>
    <div class="list_table">
        <table border="1px solid #000" width="100%">
            <tr>
                <th>ID</th>
                <th>Image</th>
                <th>Title</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listBlog}" var="o">
                <tr>
                    <td>${o.id}</td>
                    <td><img src="${o.image}"/></td>
                    <td>${o.title}</td>
                    <td>${o.description}</td>
                    <td>
                        <a href="loadBlog?pid=${o.id}" title="Edit"><i class="fa-solid fa-pen icon-edit"></i></a>
                        <a href="deleteBlog?pid=${o.id}" title="Delete"><i class="fa-solid fa-trash icon-delete"></i></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="container_footer">
        <a href="home">
            <button type="button" class="btn-backhome">Back to home</button>
        </a>
    </div>
</div>

<!-- modal -->
<div class="modal" id="myModal">
    <div class="modal-container">
        <form action="addBlog" method="post" enctype="multipart/form-data">
            <div class="modal-header">
                <p>Add Blog</p>
                <a href="" class="modal-close">
                    <i class="fa-solid fa-xmark"></i>
                </a>
            </div>

            <div class="modal-body">
                
                  <div class="div1">
                    <label class="modal-label">Image</label>
                    <div class="hero" style="align-items: center; justify-content: center;">
                        <div class="card"> 
                            <img src="./assets/img/profile.png" id="profile">
                            <label for="input-file" style="display: block;
    width: 130px;
    background: #d82e4d;
    color: #fff;
    padding: 12px;
    margin: 10px auto;
    border: 5px;
    cursor: pointer;">Upload image</label>
                            <input type="file" accept="image/jpeg, image/png, image/jpg" name="image" id="input-file" style="display: none;" />
                        </div>
                    </div>
                </div>

                <div class="div2">
                    <label class="modal-label">Title</label>
                    <input name="title" type="text" class="modal-input1"/>
                </div>

                <div class="div3">
                    <label class="modal-label">Description</label>
                    <textarea name="description" id="description" cols="120" rows="4"
                              class="modal-textarea"></textarea>
                </div>
            </div>

            <div class="modal-footer">
                <input type="button" id="input-cancel" class="modal-cancel" value="Cancel"/>
                <input type="submit" id="input-add" value="Add"/>
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
<script src="./assets/js/manage.js"></script>
</html>
