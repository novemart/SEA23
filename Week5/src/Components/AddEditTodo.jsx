import React, { useEffect, useState } from 'react'
import './css/AddEditTodo.css'
import TodoForm from './TodoForm'
import PropTypes from 'prop-types';
import generateTodoId from './utils/generateId';
import TodoModel from './utils/Todo.model';
import Modal from './utils/Modal'
import { useNavigate, useParams } from 'react-router';

const AddEditTodo = ({submitAction, data}) => {
  const [todo, setTodo] = useState(null);
  const [submitted, setSubmitted] = useState(false);
  const {_id} = useParams();
  let navigate = useNavigate();

    useEffect(() => {
      if (!_id) setTodo(null);
      if (_id && !todo?.error) {
          const todoToEdit = data?.todos?.find(currentTodo => currentTodo._id === _id);
          if (todoToEdit) {
              setTodo(todoToEdit)
          } else {
              setTodo({ error: `Todo could not be found` });
          }
      }
  }, [_id, data, todo])

    const submitTodo=(todoDescription, todoDateCreated, todoCompleted, todoId)=>{
      const id = todoId ? todoId : generateTodoId();
        const newTodo = new TodoModel(todoDescription, new Date(todoDateCreated).toISOString(), todoCompleted, _id);
        submitAction(newTodo);
        setSubmitted(true);
        return navigate("/")
    }
  return (
    <>
     
    {todo?.error && <Modal handleClose={() => setTodo(null)} message={todo.error} />}
    <div className='addEditTodo row'>
    <h3>{_id ? `Edit` : `Add`} Todo</h3>
        
    </div>
    <TodoForm submitAction={submitTodo} todo={todo}/>
    </>
  )
}
AddEditTodo.propTypes={
    submitTodo: PropTypes.func.isRequired
}
export default AddEditTodo