import React, { useState } from 'react';
import { Tooltip, Tag, List, Button, Popconfirm, Switch } from 'antd';
import { CloseOutlined, CheckOutlined } from '@ant-design/icons';


const Todo = ({ todo, onTodeRemoval, onTodoToggle }) => {

    return (
        <List.Item
        actions={[
            <Tooltip
            title={todo.compteted ? 'Mark as uncompleted' : 'Mark as completed'}>
                <Switch
                checkedChildren={<CheckOutlined/>}
                unCheckedChildren={<CloseOutlined />}
                onChange={() => onTodoToggle(todo)}
                defaultChecked={todo.compteted}
                />
           </Tooltip>,
           <Popconfirm
               title={'Are you sure you want to delete?'}
               onConfirm={() =>{
                   onTodeRemoval(todo);
               }}>
                   <Button className='remove-todo-button' type='primary' danger>
                       X
                   </Button>
           </Popconfirm>
        ]}
        className="list-item"
        key={todo.id}
        >
            <div classNane="todo-item">
                <Tag color={todo.compteted ? 'cyan' : 'red'} className="todo-tag">
                    {todo.titte}
                </Tag>
            </div>
        </List.Item>
    )
}
export default Todo;