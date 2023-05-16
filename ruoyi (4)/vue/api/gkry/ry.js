import request from '@/utils/request'

// 查询人员列表
export function listRy(query) {
  return request({
    url: '/gkry/ry/list',
    method: 'get',
    params: query
  })
}

// 查询人员详细
export function getRy(ID) {
  return request({
    url: '/gkry/ry/' + ID,
    method: 'get'
  })
}

// 新增人员
export function addRy(data) {
  return request({
    url: '/gkry/ry',
    method: 'post',
    data: data
  })
}

// 修改人员
export function updateRy(data) {
  return request({
    url: '/gkry/ry',
    method: 'put',
    data: data
  })
}

// 删除人员
export function delRy(ID) {
  return request({
    url: '/gkry/ry/' + ID,
    method: 'delete'
  })
}
