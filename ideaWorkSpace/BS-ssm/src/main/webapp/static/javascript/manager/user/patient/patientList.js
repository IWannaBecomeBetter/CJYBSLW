/**
 * Created by 93701 on 2016/9/13.
 */
/**
 * Created by 93701 on 2016/9/12.
 */
/**
 * Created by joeshao on 16/9/9.
 */

var patientList = {
    init: function () {
        var that = this;
        that.initDatePicker(); //初始化时间选择控件
        that.initTable(); //初始化列表
        that.bindEvent(); //绑定时间
    },
    initDatePicker: function () {
        jQuery('.datepicker-autoclose').datepicker({
            autoclose: true,
            todayHighlight: true,
            format: 'yyyy-mm-dd'
        });
    },
    initTable: function () {
        this.dataTable = $('#myTable').dataTable({
            sAjaxSource: base+'/patient/list',   //ajax地址
            fnServerParams: function (aoData) {        //将form中的查询条件加到提交参数中
                aoData.push({name: "search", value: $('input[name="telephone"]').val()});
                aoData.push({name: "status", value: $('select[name="status"]').val()});
                aoData.push({name: "startTime", value: $('input[name="startTime"]').val()});
                aoData.push({name: "endTime", value: $('input[name="endTime"]').val()});
            },
            aoColumns: [                //列定义
                {
                    mDataProp: 'telephone',
                    sTitle: '联系方式',
                    bSortable: false,
                    mRender: function (data, type, full) { //渲染函数,即 td 内显示的内容
                        return '<a href="javascript: patientDetail(' + full.id + ')">' + full.telephone + '</a>';
                    }

                },
                {
                    mDataProp: 'name',
                    sTitle: '名称',
                    bSortable: false,

                },
                {
                    mDataProp: 'email',
                    sTitle: '邮箱',
                    bSortable: false,

                },
                {
                    mDataProp: 'status',
                    sTitle: '状态',
                    mRender: function (data, type, full) { //渲染函数,即 td 内显示的内容
                        if (data == 0) {
                            return '失效';
                        } else if (data == 1) {
                            return '未认证';
                        } else if (data == 2) {
                            return '待审核';
                        } else if (data == 3) {
                            return '已认证';
                        } else if (data == -1) {
                            return '认证失败';
                        }
                    },
                    bSortable: false,
                },
                {
                    mDataProp: 'createTime',
                    sTitle: '注册时间',
                    mRender: function (data, type, full) { //渲染函数,即 td 内显示的内容

                        return dateFormat(data,'yyyy-MM-dd hh:mm',true);
                    }
                },
                {
                    mDataProp: null,
                    sTitle: '操作',
                    mRender: function (data, type, full) {
                        var status = full.status;
                        var html = '';
                        if(status == 2){
                            html += '<button class="btn btn-outline btn-danger" onClick="toPatientModel(' + full.id + ')">实名认证</button>';
                        }
                        if(status == 1 || status == 2 || status == 3){
                            html += '<button class="btn btn-outline btn-info" onClick="patientDetail(' + full.id + ')">详情</button>';
                        }
                        html += '<button class="btn btn-outline btn-info" onClick="deleteUser('+full.id+')">删除</button>';
                        return html;
                    },
                    bSortable: false
                }
            ]
        });

    },
    bindEvent: function () {
        var that = this;
        $('.search').on('click', function () {
            that.dataTable.fnDraw();
        });
        $('.reset').on('click',function(){
            $('#searchForm')[0].reset();
            that.dataTable.fnDraw();
        });
    }
};

/**
 * 刷新数据列表
 */
var refreshList = function () {
    patientList.dataTable.fnDraw();
};


/**
 * 患者详情
 * @param accoutId
 */
var patientDetail = function (data){
    toPatientModel(data);
};


$(function () {
    patientList.init();
});