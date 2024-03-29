<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${beanName}</title>
    <link rel="stylesheet" type="text/css" media="screen" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="../../css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all"/>
</head>
<body>
<div>
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <div>
            <header style="height: 100%">
                <div align="left">
                    <table style="width: 100%">
                        <tr>
                            <td>
                                <form class="form-inline" onsubmit="return false">
                                    <div class="form-group">
                                        type：
                                        <input id="type" type="text" class="form-control" placeholder="type">
                                        <button id="searchBt" class="layui-btn layui-btn-sm"
                                                permission="${classUrl}:query"><i class="layui-icon">&#xe615;</i>搜索
                                        </button>
                                    </div>
                                </form>
                            </td>
                            <td align="right">
                                <button class="layui-btn layui-btn-sm" onclick="location.href='${classUrl}Add.html'"
                                        permission="${classUrl}:add">
                                    <i class="layui-icon">&#xe608;</i> 添加
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>
            </header>

            <div>
                <div class="widget-body no-padding">
                    <table id="dt-table" class="table table-striped table-bordered table-hover" style="width:100%">
                        <thead>
                        <tr>
                        </tr>
                        <tr>
									<#list fieldList as var>
									<th>${var.name}</th>
                                    </#list>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script type="text/javascript" src="../../js/jq.js"></script> 
<script type="text/javascript" src="../../js/libs/jquery-2.1.1.min.js"></script> 
<script type="text/javascript" src="../../js/plugin/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../../js/plugin/datatables/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="../../layui/layui.js"></script> 
<script type="text/javascript">

    var example;

    function init() {
        example =
                $('#dt-table').DataTable({
                    "searching": false,
                    "processing": false,
                    "serverSide": true,
                    "language": {
                        "url": "/js/plugin/datatables/Chinese.lang"
                    },

                    "ajax": {
                        "url": "/${classUrl}/list",
                        "type": "post",
                        "data": function (d) {
                            d.type = $("#type").val();
                        }
                    },
                    "dom": "<'dt-toolbar'r>t<'dt-toolbar-footer'<'col-sm-10 col-xs-12 hidden-xs'i><'col-xs-12 col-sm-10' p v>>",
                    "columns": [
				<#list fieldList as var>
				{"data": "${var.name}", "defaultContent": ""},
                </#list>
                        {
                            "data": "",
                            "defaultContent": "",
                            "orderable": false,
                            "render": function (data, type, row) {
                                var id = row['id'];
                                var href = "${classUrl}Update.html?id=" + id;
                                var edit = buttonEdit(href);
                                var del = buttonDel(id);
                                return edit + del;
                            }
                        },

                    ],
                    "order": [[0, "asc"]]
                });
    }

    layui.use('layer', function () {
        var layer = layui.layer;
    });

    function del(id) {
        layer.confirm('确定要删除吗？', {
            btn: ['确定', '取消']
        }, function () {

            $.ajax({
                type: 'post',
                url: '/${classUrl}/del',
                contentType: 'application/json;charset=utf-8',
                data: id,
                success: function (data) {
                    example.ajax.reload();
                    layer.msg("删除成功");
                }
            });

            layer.close(1);
        });
    }

    $("#searchBt").click(function () {
        example.ajax.reload();
    });

    init();
</script>
