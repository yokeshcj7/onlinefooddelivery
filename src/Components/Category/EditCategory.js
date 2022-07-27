import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { useParams,useNavigate } from 'react-router-dom';

function EditCategory() {

    const [cId, setCId] = useState('');
    const [cName, setCName] = useState('');

    const { id } = useParams();
   const navigate = useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8080/category/viewCategory/"+id).then(resp => {
            setCId(resp.data.id);
            setCName(resp.data.name);
        });
    }, [id])
    
    const handleSubmit = () => {
        const payload = {
            id: cId,
            name: cName
        }
        axios.put("http://localhost:8080/category/updateCategory/",payload).then(resp => navigate(-1)
        ).catch(error=>console.log("something wrong"))
    }

    return (
        <div>
            <div>
                <h3 className="text-center">Please Update the Category Name</h3>
                <label>CategoryId</label>
                <input type="text" id="cId" name="cId" value={cId} disabled></input>
            </div>
            <div>
                <label>CategoryName</label>
                <input type="text" id="cName" name="cName" value={cName} onChange={e => setCName(e.target.value)}></input>
            </div>
            <div>
                <button onClick={handleSubmit}>Submit</button>
            </div>
        </div>
    )
}

export default EditCategory;