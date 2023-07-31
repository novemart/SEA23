import React from "react";
import Footer from "../Components/Footer";
import { create } from "react-test-renderer";


test('Footer matches snapshot', ()=>{
    const footer = create(<Footer />)
    expect (footer.toJSON()).toMatchSnapshot();
})