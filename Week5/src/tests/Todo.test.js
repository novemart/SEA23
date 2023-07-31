import { create } from 'react-test-renderer';
import TodoModel from '../Components/utils/Todo.model';
import Todo from '../Components/Todo';

jest.mock("../Components/utils/Todo.model",()=>{
    return class TodoModel{
        constructor(){
            this.todoDescription='Test Todo';
            this.todoDateCreated = '2019-05-04T15:30:00.000z';
            this.todoCompleted = true;
        }
    };
});

test('it should render 2 tds with className completed if props.todo.todoCompleted is true',()=>{
    const testTodo = new TodoModel();
    const testRenderer = create(<Todo todo={testTodo} />)
    const testInstance = testRenderer.root;
    const cells = testInstance.findAllByType('td');
    for( let i=0, j=cells.length-1; i<j; i++){
        expect(cells[i].props.className).toBe('completed');
    }
})