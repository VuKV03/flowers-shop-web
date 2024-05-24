<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Product</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="./assets/css/editProduct.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div class="modal">
    <div class="modal-container">
        <form action="edit" method="post" enctype="multipart/form-data">
            <div class="modal-header">
                <p>Edit Product</p>
            </div>

            <div class="modal-body">
                <div class="row1">
                    <div class="row1_col">
                        <label class="modal-label">ID</label>
                        <input value="${detail.id}" name="id" type="text" class="modal-input" readonly required></input>
                    </div>

                    <div class="row1_col1">
                        <label class="modal-label">Name</label>
                        <input value="${detail.name}" name="name" type="text" class="modal-input1" required></input>
                    </div>

                    <div class="row1_col2">
                        <label class="modal-label">Description</label>
                        <textarea name="description" id="description" cols="40" rows="6"
                                  class="modal-textarea" required>${detail.description}</textarea>
                    </div>
                </div>

                <div class="row2">
                    <div class="row2_col1">
                        <label class="modal-label">Cost Price</label>
                        <input value="${detail.costPrice}" name="cost_price" type="text" class="modal-input2" required></input>
                    </div>

                    <div class="row2_col2">
                        <label class="modal-label">Sale Price</label>
                        <input value="${detail.salePrice}" name="sale_price" type="text" class="modal-input3" required></input>
                    </div>
                </div>

                <div class="row3">
                    <div class="div1">
							<label class="modal-label">Image Primary</label>
							<div class="hero"
								style="align-items: center; justify-content: center;">
								<div class="card">
                                    <label
                                            for="input-file"
                                            class="css-label-img" >Upload image</label>
									<img src="${detail.img_primary}" id="profile" style="width: 100px; height: 100px; top: -20px; position: relative;">
										<input type="file"
										accept="image/jpeg, image/png, image/jpg" name="img_primary"
										id="input-file" style="display: none;" /> 
										<input
										value="${detail.img_primary}" name="img_primarys" type="hidden">
								</div>
							</div>
						</div>

                    <div class="div1">
							<label class="modal-label">Image Secondary</label>
							<div class="hero"
								style="align-items: center;
	/* width: 150px; 
                    height: 150px; */ justify-content: center;">
								<div class="card">
                                    <label
                                            for="input-file2"
                                    <%--										style="display: block; width: 130px; background: #e3362c; color: #fff; padding: 12px; margin: 10px auto; F border: 5px; cursor: pointer;"--%>
                                            class="css-label-img"> Upload image</label>
                                    <img src="${detail.img_second}" id="profile2"
										style="width: 100px; height: 100px; top: -20px; position: relative;">
                                    <input type="file"
										accept="image/jpeg, image/png, image/jpg" name="img_second"
										id="input-file2" style="display: none;" /> <input
										value="${detail.img_second}" name="img_seconds" type="hidden">
								</div>
							</div>
						</div>
                </div>

                <div class="row4">
                    <label class="modal-label">Category</label>
                    <select name="cate" id="cate" class="modal-option">
                        <c:forEach items="${listC}" var="o">
                            <option value="${o.cid}">${o.cname}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="modal-footer">
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
        
        let profilePic2 = document.getElementById("profile2")
        let inputFile2 = document.getElementById("input-file2");

        inputFile2.onchange = function () {
            profilePic2.src = URL.createObjectURL(inputFile2.files[0]);
        }
</script>
</html>
