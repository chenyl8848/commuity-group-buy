<template>
  <div style="padding: 30px">
    <el-form ref="form" :model="queryForm" label-width="80px">
      <el-row :gutter="20">
        <el-col :span="18">
          <el-row :gutter="20">
            <el-col :span="8">
              <el-form-item label="用户账号">
                <el-input v-model="queryForm.username"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="用户昵称">
                <el-input v-model="queryForm.name"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="6">
          <el-form-item>
            <el-button type="primary">查询</el-button>
            <el-button>重置</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>
    <div>
      <el-table :data="tableData" style="width: 100%" border>
        <el-table-column prop="date" label="日期" width="180">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="180">
        </el-table-column>
        <el-table-column prop="address" label="地址"> </el-table-column>
      </el-table>
    </div>
    <div class="page">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage4"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getUserList } from "@/api/auth/sysuser";
export default {
  data() {
    return {
      queryForm: {
        username: "",
        name: "",
      },
      currentPage4: 4,
      tableData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄",
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄",
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄",
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1516 弄",
        },
      ],
    };
  },
  mounted() {
    this.getList();
  },
  methods: {
    getList() {
      getUserList(1, 2, {username: '', name: ''})
        .then((res) => {
          console.log(res, "fffffffffffffffff");
        })
        .catch((error) => {
          console.log(error);
        });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    },
  },
};
</script>

<style scoped>
</style>
