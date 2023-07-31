import React from 'react'
import TodoModel from './utils/Todo.model';
import PropTypes from 'prop-types';
import { Link } from 'react-router-dom';

const Todo = ({todo}) => {
    console.log(todo);
    const dateCreated = new Date(Date.parse(todo.todoDateCreated)).toUTCString();
    const completedClassName = todo.todoCompleted ? 'completed' : '';
    const completed = todo.todoCompleted? 'N/A' : <Link className="link" to={`/edit/${todo._id}`}>Edit</Link>;
  return (
    <>
    <tr>
        <td className={completedClassName}>{todo.todoDescription}</td>
        <td className={completedClassName}>{dateCreated}</td>
        <td>{completed}</td>
    </tr>
    </>
  )
}
Todo.propTypes={
    todo: PropTypes.instanceOf(TodoModel)
}
export default Todo