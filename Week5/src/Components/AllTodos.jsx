import React, { useEffect, useState } from 'react'
import './css/AllTodos.css';
import TodoModel from './utils/Todo.model';
import Todo from './Todo';
import PropTypes from 'prop-types';

const AllTodos = ({data}) => {
    const [dataStatus, setDataStatus] = useState({name:'loading', message:'Data is loading'})
    const todos = data.todos?.map(e=>{
        const newtodo = new TodoModel(e.todoDescription, e.todoDateCreated, e.todoCompleted, e._id);
        return <Todo todo={newtodo} key={newtodo._id} />
    })

    useEffect(()=>{
        if (data?.error) {
            setDataStatus({ name: `error`, message: data.error });
        }
        else if (data?.todos) {
            const ds = data.todos.length > 0 ? { name: `data`, message: null } : { name: `nodata`, message: `There were no todos previously saved` };
            setDataStatus(ds);
        }
        else {
            setDataStatus({ name: `loading`, message: `Data is loading...` });
        }
    },[data])


    const populateTable = ()=>{
        if (data?.todos?.length > 0){
            return data.todos.map(e=>{
                const newtodo = new TodoModel(e.todoDescription, e.todoDateCreated, e.todoCompleted, e._id);
                return <Todo todo={newtodo} key={newtodo._id} />
        })
    }
    else{
        return (
            <tr><td id={dataStatus.name} colSpan="3">{dataStatus.message}</td></tr>
        );
    }
}

  return (
    <div className='row'>
        <h3>Todo List</h3>
        <table className='table table-striped'>
            <thead><tr>
                <th>Description</th>
                <th>Date Created</th>
                <th>Action</th>
                </tr></thead>
                <tbody>
                    {populateTable()}
                </tbody>
        </table>
    </div>
  )
}
AllTodos.propTypes={
    data: PropTypes.oneOfType([
        PropTypes.exact({
            todos: PropTypes.arrayOf(
                PropTypes.exact({
                    _id: PropTypes.string,
                    todoDescription: PropTypes.string,
                    todoDateCreated: PropTypes.string,
                    todoCompleted: PropTypes.bool
                })
            )
        }),
        PropTypes.exact({
            error: PropTypes.string
        }),
        PropTypes.exact({})
    ])
}

export default AllTodos