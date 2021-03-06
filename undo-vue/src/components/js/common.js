const MeConfig = {
  isDrawer: false
}

const User = {
  isLogin: false,
  id: "",
  username: "",
  sign: "",
  email: "",
  avatar: "",
  token: "",
  reset() {
    User.id = User.username = User.sign = User.email = User.avatar = User.token = ""
    User.isLogin = false
  }
}

const UserArticle = {
  allClazz: [],
  articles: [],
  statistics: {
    clazzNum: 0,
    like: 0,
    number: 0,
    visit: 0,
  }, nowClazzId: 0
}

const LoginDialogConfig = {
  isDialog: false,
  isLogin: true,
}

const LoginForm = {
  email: "",
  password: "",
  reset() {
    LoginForm.email = LoginForm.password = ""
  }
}

const LoginFromRules = {
  email: [
    {required: true, message: '请输入邮箱', trigger: 'blur'},
    {min: 5, max: 30, message: '长度在 5 到 30 个字符', trigger: 'blur'}
  ], password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur'}
  ]
}

const RegisterForm = {
  username: "",
  email: "",
  password: "",
  checkPassword: "",
  code: "",
  reset() {
    RegisterForm.username = RegisterForm.email = RegisterForm.password = RegisterForm.checkPassword = RegisterForm.code = ""
  }
}

const RegisterFormRules = {
  username: [
    {required: true, message: '请输入昵称', trigger: 'blur'},
    {min: 3, max: 16, message: '长度在 3 到 16 个字符', trigger: 'blur'}
  ], email: [
    {required: true, message: '请输入邮箱', trigger: 'blur'},
    {min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur'}
  ], password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 3, max: 30, message: '长度在 3 到 30 个字符', trigger: 'blur'}
  ], checkPassword: [
    {required: true, message: '请输入验证密码', trigger: 'blur'},
    {min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur'}
  ], code: [
    {required: true, message: '请输入密码', trigger: 'blur'},
    {min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur'}
  ]
}

const Searcher = {
  input: "",
  hasMore: false,
  nowPage: 1,
  reading: false
}

const UserNowEdit = {
  field: "",
  newVal: ""
}

const ClazzNowEdit = {
  id: "",
  newVal: ""
}

const ArticleNowEdit = {
  id: "",
  title: "",
  summary: "",
  updateSummary: "",
  content: "",
  clazzId: "",
  isPrivate: "",
  reset() {
    this.id = undefined
    this.title = this.summary = this.updateSummary = this.content = this.clazzId = this.isPrivate = ""
  }
}

const ArticleNowShow = {
  user: {
    sign: "",
    id: "",
    avatar: "",
    username: "",
    reset() {
      this.sign = this.id = this.avatar = this.username = ""
    }
  },
  isGood: "",
  reset() {
    for (let a in this) {
      if (a !== "reset") {
        this[a] = ""
      }
    }
  }
}

const Index = {
  visitRank: [],
  userRank: [],
}

const File = {
  fileList: []
}

const nowRenameFile = {
  id: "",
  name: "",
  reset() {
    this.id = this.name = ""
  }
}

const say = {
  says: []
}


export default {
  MeConfig,
  LoginDialogConfig,
  LoginFromRules,
  User,
  Searcher,
  UserArticle,
  LoginForm,
  RegisterForm,
  RegisterFormRules,
  UserNowEdit,
  ClazzNowEdit,
  ArticleNowEdit,
  ArticleNowShow,
  File,
  Index,
  nowRenameFile,
  say
}
