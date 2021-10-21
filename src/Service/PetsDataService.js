import axios from 'axios'

const PETS_API_URL = 'http://localhost:8080'
class PetsDataService
{
    getAllPets()
    {
        return axios.get(`${PETS_API_URL}/getPets`);
    }
}

export default new PetsDataService()