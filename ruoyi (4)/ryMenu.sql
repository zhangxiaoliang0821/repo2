-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员', '2024', '1', 'ry', 'gkry/ry/index', 1, 0, 'C', '0', '0', 'gkry:ry:list', '#', 'admin', sysdate(), '', null, '人员菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'gkry:ry:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'gkry:ry:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'gkry:ry:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'gkry:ry:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('人员导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'gkry:ry:export',       '#', 'admin', sysdate(), '', null, '');