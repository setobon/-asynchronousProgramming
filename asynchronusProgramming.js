    const validarPelicula = pelicula => {
        let promise, disponible;
        if(pelicula === "pelicula1"){
            disponible = true;
        }
        return promise = new Promise(resolve => resolve(disponible));
    };
    
    const alquilarPelicula = pelicula => {
        let promise, alquilar;
        
        if(pelicula){
            alquilar = true;
        }
        else{
            alquilar = false;
        }
        return promise = new Promise(resolve => resolve(alquilar));
    };
    
    const devolverPelicula = alquilada => {
        let promise, devuelta;
        if(alquilada){
            devuelta = true;
        }
        else{
            devuelta = false;
        }
        return promise = new Promise(resolve => resolve(devuelta));
    };
    
  let empanadas = 0;
  let pelicula = "pelicula1";
  
  async function tiendaPeliculas(){
      try{
          const peliculaValidada = await validarPelicula(pelicula);
          console.log("La pelicula existe? ", peliculaValidada);
          
          if(peliculaValidada){
                const peliculaAlquilada = await alquilarPelicula(peliculaValidada);
                console.log("La pelicula fue alquilada: ", peliculaAlquilada);
                
            if(peliculaAlquilada){
              const peliculaDevuelta = await devolverPelicula(peliculaAlquilada);
              console.log("La pelicula fue devuelta: ", peliculaDevuelta);
              }
         }
      } catch(e){
          throw "Se maneja el error: ${e}";
    }

      
  }
  tiendaPeliculas();