import React, { useEffect, useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import 'popper.js';
import 'jquery';
import './Components/css/qa.css';
import Header from './Components/Header';
import Footer from './Components/Footer';
import AllTodos from './Components/AllTodos';
import AddEditTodo from './Components/AddEditTodo';
import NotFound from './Components/utils/NotFound';
import { Route, Routes } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import axios from 'axios';
import Modal from './Components/utils/Modal';
function App() {
  const TODOSURL= 'http://localhost:4000/todos';
  const [getError, setGetError] = useState('');
  const [postError, setPostError] = useState('');
  const [putError, setPutError] = useState('');
  
  const [todos, setTodos] = useState([]);

  const submitTodo= async(todo)=>{
    setPostError('');
    try{
      await axios.post(TODOSURL,todo)
    }catch (e) {
      setPostError(`There was a problem adding the todo: ${e.message}`);
    } finally {
      setTodos(await getTodos());
    }
  }

  useEffect(()=>{
    const getData = async () =>{
      setTodos( await getTodos() );}
      getData();
  },[])


  const getTodos = async ()=>{
    try{
      const res = await axios.get(TODOSURL);
      return res.data.length? {todos: res.data} : {error:'There are no todos stored'}
    }
    catch(e){
      setGetError(`Data not available from server: ${e.message}`)
      return {error: `Data not available from server: ${e.message}`}

    }
  }

  const updateTodo = async todo => {
    setPutError(``);
    try {
      await axios.put(`${TODOSURL}/${todo._id}`, todo);
    } catch (e) {
      setPutError(`There was a problem updating the todo: ${e.message}`);
    } finally {
      setTodos(await getTodos());
    }
  };

  return (
    <BrowserRouter>
    {getError && <Modal handleClose={() => setGetError(``)} message={getError} />}
    {postError && <Modal handleClose={() => setPostError(``)} show={postError} />}
    {putError && <Modal handleClose={() => setPutError(``)} message={putError} />}
    <div className="container">
      <Header />
      
      <Routes>
      <Route path="/add" element={< AddEditTodo submitAction={submitTodo}/>} />
      <Route path="/edit/:_id" element={< AddEditTodo submitAction={updateTodo} data={todos}/>} />
      <Route path="/" element={<AllTodos data={todos}/>} />
      <Route path="" element={<NotFound/>} />
      </Routes>
      
      <Footer />
    </div>
    </BrowserRouter>

  );
}

export default App;
