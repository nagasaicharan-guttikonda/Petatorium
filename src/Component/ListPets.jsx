import React,{Component} from 'react';
import PetsDataService from '../Service/PetsDataService';

class ListPets extends Component 
{
    constructor(props)
    {
        super(props)
        this.state = {pets:[],message:null}
      //  this.getPets  = this.getPets.bind(this)
    }

    componentDidMount()
    {
        this.getPets()
    }
    getPets()
    {
        PetsDataService.getAllPets().then(response => {console.log(response);
        this.setState({pets:response.data})})
        
    }
    render(){
    return(
    
        <div>
            <table>
               <thead>
                <tr>
                    <th> PetName </th>
                    <th> PetId </th>
                    <th> PetBreed </th>
                    <th> PetAge </th>
                </tr>
                </thead>
               <tbody>
                   {this.state.pets.map(
                       pet => 
                       <tr key = {pet.petId}>
                       <td> {pet.petName} </td>
                       <td> {pet.petId} </td>
                       <td> {pet.petBreed} </td>
                       <td> {pet.petAge} </td>
                      </tr>
                   )}
               
               </tbody>
            </table>
        </div>
    
        );
        }
}



export default ListPets;