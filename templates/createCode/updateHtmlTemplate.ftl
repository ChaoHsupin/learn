<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" media="screen" href="../../css/bootstrap.min.css">
</head>
<body>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <form class="form-horizontal" onsubmit="return false" id="form">
        <fieldset>
            <input type="hidden" id="id" name="id">
            <div class='form-group'>
                <label class='col-md-2 control-label'>type</label>
                <div class='col-md-10'>
                    <input class='form-control' placeholder='type' type='text' name='type' id='type'
                           readonly="readonly">
                </div>
            </div>
            <div class='form-group'>
                <label class='col-md-2 control-label'>k</label>
                <div class='col-md-10'>
                    <input class='form-control' placeholder='k' type='text' name='k' id='k' readonly="readonly">
                </div>
            </div>
            <div class='form-group'>
                <label class='col-md-2 control-label'>val</label>
                <div class='col-md-10'>
                    <input class='form-control' placeholder='val' type='text' name='val' id='val'
                           data-bv-notempty='true' data-bv-notempty-message='val 不能为空'>
                </div>
            </div>

            <div class="form-actions">
                <div class="row" align="center">
                    <div class="col-md-12">
                        <button class="btn btn-primary" onclick="location.href='${classUrl}List.html'">返回</button>
                        <button class="btn btn-primary" type="submit" onclick="update()">
                            <i class="fa fa-save"></i> 保存
                        </button>
                    </div>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<script type="text/javascript" src="../../js/libs/jquery-2.1.1.min.js"></script>

<script type="text/javascript" src="../../js/plugin/bootstrapvalidator/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['layer', 'laydate'], function () {
        var layer = layui.layer;
    });

    initData();

    function initData() {
        var id = getUrlParam("id");
        if (id != "") {

            $.ajax({
                type: 'post',
                url: '/${classUrl}/get',
                contentType: 'application/json;charset=utf-8',
                data: id,
                async: false,
                success: function (data) {
                    $('#id').val(data.id);
                    $('#type').val(data.type);
                    $('#k').val(data.k);
                    $('#val').val(data.val);

                }
            });
        }
    }

    function update() {
        $('#form').bootstrapValidator();
        var bootstrapValidator = $("#form").data('bootstrapValidator');
        bootstrapValidator.validate();
        if (!bootstrapValidator.isValid()) {
            return;
        }

        var formdata = $("#form").serializeObject();

        $.ajax({
            type: 'put',
            url: '/${classUrl}/edit',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(formdata),
            success: function (data) {
                layer.msg("修改成功", {shift: -1, time: 1000}, function () {
                    location.href = "${classUrl}List.html";
                });
            }
        });
    }

</script>
</body>
</html>
