import { create } from 'react-test-renderer';
import sampleTodos from '../sampleTodos.json';
import AllTodos from "../Components/AllTodos";

test('it should render the correct number of todo components based on the todo array supplied',()=>{
    const sampleTodosLenght = sampleTodos.length;
    const testRenderer = create(<AllTodos data={{todos:sampleTodos}}/>);
    const testInstance = testRenderer.root;
    const tableBody = testInstance.findByType('tbody');
    expect(tableBody.children.length).toBe(sampleTodosLenght);
})