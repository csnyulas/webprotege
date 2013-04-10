package edu.stanford.bmir.protege.web.server.owlapi;


import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import edu.stanford.bmir.protege.web.server.WebProtegeFileStore;

import java.io.File;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/05/2012
 */
public class OWLAPIProjectFileStore {




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////
    //////  Data Storage
    //////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The name of the base directory where all data is stored.
     */
    private static final String BASE_DIRECTORY_NAME = "owlapi-data-store";
    
    private static final String ALL_PROJECTS_DIRECTORY_NAME = "owlapi-projects";


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////
    //////  Ontology Data Storage
    //////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String ONTOLOGY_DATA_DIRECTORY_NAME = "ontology-data";

    private static final String ROOT_ONTOLOGY_DOCUMENT_NAME = "root-ontology.binary";


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////
    //////  Change Data Storage
    //////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String CHANGE_DATA_DIRECTORY_NAME = "change-data";

//    private static final String CHANGE_HISTORY_FILE_NAME = "change-data.binary";

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////
    //////  Notes Data Storage
    //////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String NOTES_DATA_DIRECTORY_NAME = "notes-data";


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////
    //////  Download Cache
    //////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static final String DOWNLOAD_CACHE_DIRECTORY = "download-cache";

    private ProjectId projectId;

    private File projectDirectory;
    
    private File ontologyDataDirectory;

    
    private File notesDataDirectory;
    
    private File changesDataDirectory;
    
    
    private File downloadCacheDirectory;

    /**
     * Constructs a {@link OWLAPIProjectFileStore} which resides at a given location in the file system.
     * @param webProtegeDataDirectory The root directory where data will be stored.
     * @param projectId The id of the project
     */
    private OWLAPIProjectFileStore(File webProtegeDataDirectory, ProjectId projectId) {
        checkNotNull(webProtegeDataDirectory);
        this.projectId = checkNotNull(projectId);
        File baseDirectory = new File(webProtegeDataDirectory, BASE_DIRECTORY_NAME);
        File allProjectsDirectory = new File(baseDirectory, ALL_PROJECTS_DIRECTORY_NAME);
        this.projectDirectory = new File(allProjectsDirectory, getEscapedProjectName());

        this.changesDataDirectory = new File(projectDirectory, CHANGE_DATA_DIRECTORY_NAME);
        this.notesDataDirectory = new File(projectDirectory, NOTES_DATA_DIRECTORY_NAME);
        this.ontologyDataDirectory = new File(projectDirectory, ONTOLOGY_DATA_DIRECTORY_NAME);
        this.downloadCacheDirectory = new File(projectDirectory, DOWNLOAD_CACHE_DIRECTORY);
    }

    public void initDirectories() {
        projectDirectory.mkdirs();
        changesDataDirectory.mkdirs();
        notesDataDirectory.mkdirs();
        ontologyDataDirectory.mkdirs();
        downloadCacheDirectory.mkdirs();
    }

    public static OWLAPIProjectFileStore getProjectFileStore(ProjectId projectId) {
        File dataDirectory = WebProtegeFileStore.getInstance().getDataDirectory();
        return new OWLAPIProjectFileStore(dataDirectory, projectId);
    }

    private String getEscapedProjectName() {
        String projectName = projectId.getProjectName();
        return projectName.replaceAll("\\s", "-");
    }


    public File getProjectDirectory() {
        return projectDirectory;
    }

    public File getOntologyDataDirectory() {
        return ontologyDataDirectory;
    }

    public File getNotesDataDirectory() {
        return notesDataDirectory;
    }

    public File getChangesDataDirectory() {
        return changesDataDirectory;
    }

    public File getDownloadCacheDirectory() {
        return downloadCacheDirectory;
    }
}
