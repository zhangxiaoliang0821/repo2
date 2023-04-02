import request from '@/utils/request'

// 查询访客信息列表
export function listFkinformation(query) {
  return request({
    url: '/fksystem/fkinformation/list',
    method: 'get',
    params: query
  })
}

// 查询访客信息详细
export function getFkinformation(fksystemId) {
  return request({
    url: '/fksystem/fkinformation/' + fksystemId,
    method: 'get'
  })
}

// 新增访客信息
export function addFkinformation(data) {
  return request({
    url: '/fksystem/fkinformation',
    method: 'post',
    data: data
  })
}

// 修改访客信息
export function updateFkinformation(data) {
  return request({
    url: '/fksystem/fkinformation',
    method: 'put',
    data: data
  })
}

// 删除访客信息
export function delFkinformation(fksystemId) {
  return request({
    url: '/fksystem/fkinformation/' + fksystemId,
    method: 'delete'
  })
}
