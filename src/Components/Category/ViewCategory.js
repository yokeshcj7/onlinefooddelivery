import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios'


function ViewCategory() {
    const [category, setCategory] = useState(null);
    const {id} = useParams();
    useEffect(()=>{
        axios.get("http://localhost:8080/category/viewCategory/"+id).then(resp=>setCategory(resp.data));
    })
    return(
        <div>
            <h3 className="text-center">ViewCategoryById</h3>
            {
                category !=null && 
                <div>
                  <p>Category Id: {category.id}</p>
                  <p>Category Name: {category.name}</p>
                 
                </div>
            }
        </div>
    )
}
export default ViewCategory;