package com.example.labor.main.data;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.labor.main.CivilizationApplication;
import com.example.labor.main.model.Civilization;

import java.util.List;

import javax.inject.Inject;

public class CivilizationRepository implements ICivilizationRepository {
    private CivilizationDao civilizationDao;
    private LiveData<List<Civilization>> allCivilizations;

    @Inject
    public CivilizationRepository(CivilizationApplication application) {
        CivilizationDatabase database = CivilizationDatabase.getInstance(application);
        civilizationDao = database.civilizationDao();
        allCivilizations = civilizationDao.getAll();
    }

    public void insert(Civilization civilization){
        new InsertCivilizationAsyncTask(civilizationDao).execute(civilization);
    }

    public void update(Civilization civilization){
        new UpdateCivilizationAsyncTask(civilizationDao).execute(civilization);
    }

    public void delete(int index){
        Civilization civilization = getById(index);
        new DeleteCivilizationAsyncTask(civilizationDao).execute(civilization);
    }

    public void deleteAll(){
        new DeleteAllCivilizationAsyncTask(civilizationDao).execute();
    }

    public Civilization getById(int id){
        return allCivilizations.getValue().get(id);
    }

    public LiveData<List<Civilization>> getAll(){
        return allCivilizations;
    }

    private static class InsertCivilizationAsyncTask extends AsyncTask<Civilization, Void, Void>{
        private CivilizationDao civilizationDao;

        private InsertCivilizationAsyncTask(CivilizationDao civilizationDao) {
            this.civilizationDao = civilizationDao;
        }

        @Override
        protected Void doInBackground(Civilization... civilizations) {
            civilizationDao.insert(civilizations[0]);
            return null;
        }
    }

    private static class UpdateCivilizationAsyncTask extends AsyncTask<Civilization, Void, Void>{
        private CivilizationDao civilizationDao;

        private UpdateCivilizationAsyncTask(CivilizationDao civilizationDao) {
            this.civilizationDao = civilizationDao;
        }

        @Override
        protected Void doInBackground(Civilization... civilizations) {
            civilizationDao.update(civilizations[0]);
            return null;
        }
    }

    private static class DeleteCivilizationAsyncTask extends AsyncTask<Civilization, Void, Void>{
        private CivilizationDao civilizationDao;

        private DeleteCivilizationAsyncTask(CivilizationDao civilizationDao) {
            this.civilizationDao = civilizationDao;
        }

        @Override
        protected Void doInBackground(Civilization... civilizations) {
            civilizationDao.delete(civilizations[0]);
            return null;
        }
    }

    private static class DeleteAllCivilizationAsyncTask extends AsyncTask<Void, Void, Void>{
        private CivilizationDao civilizationDao;

        private DeleteAllCivilizationAsyncTask(CivilizationDao civilizationDao) {
            this.civilizationDao = civilizationDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            civilizationDao.deleteAll();
            return null;
        }
    }
}
