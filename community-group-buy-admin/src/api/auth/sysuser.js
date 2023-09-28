import request from '@/utils/request'

export function getUserList(pageNo, pageSize, data) {
    return request({
        url: `/sysuser/getList/${pageNo}/${pageSize}`,
        method: 'post',
        data
    })
}

export function getUserById(id) {
    return request({
        url: `/sysuser/info/${id}`,
        method: 'get'
    })
}

export function addUser(data) {
    return request({
        url: '/sysuser/add',
        method: 'post',
        data
    })
}

export function updateUser(data) {
    return request({
        url: '/sysuser/update',
        method: 'put',
        data
    })
}

export function removeUser(id) {
    return request({
        url: `/sysuser/delete/${id}`,
        method: 'delete'
    })
}

export function login(data) {
    return request({
      url: '/sysuser/login',
      method: 'post',
      data
    })
  }
  
  export function getUserInfo(token) {
    return request({
      url: '/sysuser/getInfo',
      method: 'get',
      params: { token }
    })
  }
  
  export function logout() {
    return request({
      url: '/sysuser/logout',
      method: 'post'
    })
  }
  
