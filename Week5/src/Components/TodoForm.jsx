import React, { useEffect, useState } from 'react'
import DateCreated from './utils/DateCreated'
import PropTypes from 'prop-types';

const TodoForm = ({submitAction, todo}) => {
    const [todoDescription, setTodoDescription] = useState(``);
    const [todoDateCreated, setTodoDateCreated] = useState(null);
    const [todoCompleted, setTodoCompleted] = useState(false);

    useEffect(() => {
        if (todo) {
            setTodoDescription(todo.todoDescription);
            setTodoDateCreated(todo.todoDateCreated);
            setTodoCompleted(todo.todoCompleted);
        }

        return (() => {
            setTodoDescription(``);
            setTodoDateCreated(null);
            setTodoCompleted(false);
        });
    }, [todo]);

    const handleSubmit=(event)=>{
        event.preventDefault();
        submitAction(todoDescription, todoDateCreated, todoCompleted,  todo?._id);
        setTodoCompleted(false);
        setTodoDateCreated(null);
        setTodoDescription("");
    }
  
    return (
    <form onSubmit={handleSubmit}>
        <div className='form-group'>
            <label for="todoDescription">Description: &nbsp;</label>
            <input type="text" name="todoDescription" value={todoDescription} placeholder="Todo Description"
            onChange={event=>setTodoDescription(event.target.value)} className='form-control' />
        </div>
        <div className='form-group'>
            <label for="todoDateCreated">Created on: &nbsp;</label>
            {todo && `${new Date(todo.todoDateCreated).toLocaleDateString()} @ ${new Date(todo.todoDateCreated).toLocaleTimeString()}`}
                {!todo && <DateCreated updateDateCreated={dateCreated => setTodoDateCreated(dateCreated)} />}</div>
                { todo &&
                <div className="form-group">
                    <label htmlFor="todoCompleted">Completed:&nbsp;</label>
                    <input
                        type="checkbox"
                        name="todoCompleted"
                        checked={todoCompleted}
                        onChange={event => setTodoCompleted(event.target.checked)}
                    />
                </div>
            }
            <div className="form-group">
                <input type="submit" value="Submit" className={`btn ${!todoDescription ? `btn-danger` : `btn-primary`}`} disabled={!todoDescription} />
            </div>
    </form>
  )
}
TodoForm.propTypes={
    submitTodo: PropTypes.func.isRequired
}
export default TodoForm