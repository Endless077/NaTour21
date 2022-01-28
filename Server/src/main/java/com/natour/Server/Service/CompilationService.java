package com.natour.Server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natour.Server.Model.Compilation;
import com.natour.Server.Repository.CompilationRepository;
import com.natour.Server.ServiceInterface.ICompilationService;

@Service("mainCompilationService")
public class CompilationService implements ICompilationService{

	@Autowired
	private CompilationRepository compilationRep;

	/*********************************************************************************************/

	//Constructor
	public CompilationService() {}

	/*********************************************************************************************/

	//Methods
	@Override
	public List<Compilation> getAllCompilation(){
		return this.compilationRep.findAll();
	}
	
	@Override
	public Optional<Compilation> getCompilation(Long idCompilation){
		return this.compilationRep.findById(idCompilation);
	}
	
	@Override
	public boolean creaCompilation(Compilation compilation) {
		try {
			if(!this.compilationRep.existsById(compilation.getId_compilation()))
				this.compilationRep.save(compilation);
			else
				return false;
		}catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCompilation(Long id_compilation) {
		try {
			if(this.compilationRep.existsById(id_compilation))
				this.compilationRep.deleteById(id_compilation);
			else
				return false;
		}catch(IllegalArgumentException e){
			return false;
		}
		return true;
	}

	/*********************************************************************************************/

	//Getter e Setter
	public CompilationRepository getCompilationRep() {
		return compilationRep;
	}

	/*********************************************************************************************/

}
