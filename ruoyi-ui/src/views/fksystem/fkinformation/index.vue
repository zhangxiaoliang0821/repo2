<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="访客名称" prop="fksystemName">
        <el-input
          v-model="queryParams.fksystemName"
          placeholder="请输入访客名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="fksystemAge">
        <el-input
          v-model="queryParams.fksystemAge"
          placeholder="请输入年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="住址" prop="fksystemAddress">
        <el-input
          v-model="queryParams.fksystemAddress"
          placeholder="请输入住址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="日期" prop="fksystemBirthday">
        <el-date-picker clearable
          v-model="queryParams.fksystemBirthday"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['fksystem:fkinformation:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['fksystem:fkinformation:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['fksystem:fkinformation:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['fksystem:fkinformation:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="fkinformationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="编号" align="center" prop="fksystemId" />
      <el-table-column label="访客名称" align="center" prop="fksystemName" />
      <el-table-column label="年龄" align="center" prop="fksystemAge" />
      <el-table-column label="住址" align="center" prop="fksystemAddress" />
      <el-table-column label="性别" align="center" prop="fksystemSex" />
      <el-table-column label="状态" align="center" prop="fksystemStatus" />
      <el-table-column label="日期" align="center" prop="fksystemBirthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.fksystemBirthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['fksystem:fkinformation:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['fksystem:fkinformation:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改访客信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="访客名称" prop="fksystemName">
          <el-input v-model="form.fksystemName" placeholder="请输入访客名称" />
        </el-form-item>
        <el-form-item label="年龄" prop="fksystemAge">
          <el-input v-model="form.fksystemAge" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="住址" prop="fksystemAddress">
          <el-input v-model="form.fksystemAddress" placeholder="请输入住址" />
        </el-form-item>
        <el-form-item label="日期" prop="fksystemBirthday">
          <el-date-picker clearable
            v-model="form.fksystemBirthday"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFkinformation, getFkinformation, delFkinformation, addFkinformation, updateFkinformation } from "@/api/fksystem/fkinformation";

export default {
  name: "Fkinformation",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 访客信息表格数据
      fkinformationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        fksystemName: null,
        fksystemAge: null,
        fksystemAddress: null,
        fksystemSex: null,
        fksystemStatus: null,
        fksystemBirthday: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询访客信息列表 */
    getList() {
      this.loading = true;
      listFkinformation(this.queryParams).then(response => {
        this.fkinformationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        fksystemId: null,
        fksystemName: null,
        fksystemAge: null,
        fksystemAddress: null,
        fksystemSex: null,
        fksystemStatus: null,
        fksystemBirthday: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.fksystemId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加访客信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const fksystemId = row.fksystemId || this.ids
      getFkinformation(fksystemId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改访客信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.fksystemId != null) {
            updateFkinformation(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFkinformation(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const fksystemIds = row.fksystemId || this.ids;
      this.$modal.confirm('是否确认删除访客信息编号为"' + fksystemIds + '"的数据项？').then(function() {
        return delFkinformation(fksystemIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('fksystem/fkinformation/export', {
        ...this.queryParams
      }, `fkinformation_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
