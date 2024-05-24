<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit User</title>
    <link rel="icon" type="image/x-icon" href="./assets/image/image-icons/coll_1_medium.png">
    <link rel="stylesheet" href="./assets/css/editProduct.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
</head>
<body>
<div class="modal">
    <div class="modal-container">
        <form action="editAccount" method="post">
            <div class="modal-header">
                <p>Edit Account</p>
            </div>

            <div class="modal-body">
                <div class="row1">
                    <div class="row1_col1">
                        <label class="modal-label">ID</label>
                        <input value="${detail.id}" name="id" type="text" class="modal-input" readonly required></input>
                    </div>

                    <div class="row1_col1">
                        <label class="modal-label">Name</label>
                        <input value="${detail.name}" name="name" type="text" class="modal-input1" required></input>
                    </div>

                    <div class="row1_col1">
                        <label class="modal-label">Email</label>
                        <input value="${detail.email}" name="email" type="text" class="modal-input1" required></input>
                    </div>

                    <div class="row1_col1">
                        <label class="modal-label">Phone</label>
                        <input value="${detail.phone}" name="phone" type="text" class="modal-input1" required></input>
                    </div>

                    <div class="row4">
                        <label class="modal-label" style="padding-right: 34px;">Role</label>
                        <select name="role" id="role" class="modal-option">
                            <option value="0" ${detail.isSell == 0 ? 'selected' : ''}>Người mua</option>
                            <option value="1" ${detail.isSell == 1 ? 'selected' : ''}>Người bán</option>
                        </select>
                        
                    </div>
                </div>

                <div class="modal-footer" style="margin-left: -200px;">
                    <input type="submit" id="input-add" value="Edit"/>
                </div>
        </form>
    </div>
</div>
</body>
</html>
