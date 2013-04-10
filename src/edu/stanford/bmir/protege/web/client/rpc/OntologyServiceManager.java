package edu.stanford.bmir.protege.web.client.rpc;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.stanford.bmir.protege.web.client.rpc.data.*;
import edu.stanford.bmir.protege.web.shared.project.ProjectId;
import org.semanticweb.owlapi.model.OWLClass;

public class OntologyServiceManager {

    private static OntologyServiceAsync proxy;
    static OntologyServiceManager instance;

    public static OntologyServiceManager getInstance() {
        if (instance == null) {
            instance = new OntologyServiceManager();
        }
        return instance;
    }

    private OntologyServiceManager() {
        proxy = (OntologyServiceAsync) GWT.create(OntologyService.class);
    }

//    /*
//     * Project management methods
//     */
//
//    public void loadProject(ProjectId projectId, AsyncCallback<Integer> cb) {
//        proxy.loadProject(projectId.getProjectName(), cb);
//    }
//


//    public void getEvents(ProjectId projectId, long fromVersion, AsyncCallback<List<OntologyEvent>> cb) {
//        proxy.getEvents(projectId.getProjectName(), fromVersion, cb);
//    }

    public void hasWritePermission(ProjectId projectId, UserId userId, AsyncCallback<Boolean> cb) {
        proxy.hasWritePermission(projectId.getProjectName(), userId.getUserName(), cb);
    }

//    /*
//     * Ontology methods
//     */
//
//    public void getAnnotationProperties(ProjectId projectId, String entityName, AsyncCallback<List<AnnotationData>> cb) {
//        proxy.getAnnotationProperties(projectId.getProjectName(), entityName, cb);
//    }

    public void getImportedOntologies(ProjectId projectId, AsyncCallback<ImportsData> cb) {
        proxy.getImportedOntologies(projectId.getProjectName(), cb);
    }

    public void getMetrics(ProjectId projectId, AsyncCallback<List<MetricData>> cb) {
        proxy.getMetrics(projectId.getProjectName(), cb);
    }

    /*
     * Entity methods
     */

    public void getEntityTriples(ProjectId projectId, String entityName, AsyncCallback<List<Triple>> cb) {
        proxy.getEntityTriples(projectId.getProjectName(), entityName, cb);
    }

    public void getEntityTriples(ProjectId projectId, List<String> entities, List<String> properties,
            AsyncCallback<List<Triple>> cb) {
        proxy.getEntityTriples(projectId.getProjectName(), entities, properties, cb);
    }

    public void getEntityTriples(ProjectId projectId, List<String> entities, List<String> properties, List<String> reifiedProperties,
            AsyncCallback<List<Triple>> cb) {
        proxy.getEntityTriples(projectId.getProjectName(), entities, properties, reifiedProperties, cb);
    }

    public void getEntityPropertyValues(ProjectId projectId, List<String> entities, List<String> properties, List<String> reifiedProps,
            AsyncCallback<List<EntityPropertyValues>> cb) {
        proxy.getEntityPropertyValues(projectId.getProjectName(), entities, properties, reifiedProps, cb);
    }

    public void getRootEntity(ProjectId projectId, AsyncCallback<EntityData> cb) {
        proxy.getRootEntity(projectId.getProjectName(), cb);
    }

    public void renameEntity(ProjectId projectId, String oldName, String newName, UserId userId,
            String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.renameEntity(projectId.getProjectName(), oldName, newName, userId.getUserName(), operationDescription, cb);
    }

    public void getEntity(ProjectId projectId, String entityName, AsyncCallback<EntityData> cb) {
        proxy.getEntity(projectId.getProjectName(), entityName, cb);
    }

//    public void deleteEntity(ProjectId projectId, String entityName, UserId userId, String operationDescription,
//            AsyncCallback<Void> cb) {
//        proxy.deleteEntity(projectId.getProjectName(), entityName, user, operationDescription, cb);
//    }

    /*
     * Class methods
     */

    public void getSubclasses(ProjectId projectId, String className, AsyncCallback<List<SubclassEntityData>> cb) {
        proxy.getSubclasses(projectId.getProjectName(), className, cb);
    }

    public void getIndividuals(ProjectId projectId, String className, AsyncCallback<List<EntityData>> cb) {
        proxy.getIndividuals(projectId.getProjectName(), className, cb);
    }

    public void getIndividuals(ProjectId projectId, String className, int start, int limit, String sort, String dir,
            AsyncCallback<PaginationData<EntityData>> cb) {
        proxy.getIndividuals(projectId.getProjectName(), className, start, limit, sort, dir, cb);
    }

//    public void createCls(ProjectId projectId, String clsName, OWLClass superCls, UserId userId,
//            String operationDescription, AsyncCallback<EntityData> cb) {
//        proxy.createCls(projectId, clsName, superCls, userId, operationDescription, cb);
//    }

//    public void createCls(ProjectId projectId, String clsName, OWLClass superCls, boolean createMetaClses, UserId userId,
//            String operationDescription, AsyncCallback<EntityData> cb) {
//        proxy.createCls(projectId, clsName, superCls,createMetaClses, userId, operationDescription, cb);
//    }

    public void createClsWithProperty(ProjectId projectId, String clsName, OWLClass superCls, String propertyName,
            EntityData propertyValue, UserId userId, String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createClsWithProperty(projectId, clsName, superCls, propertyName, propertyValue, userId, operationDescription, cb);
    }

    public void addSuperCls(ProjectId projectId, String clsName, String superClsName, UserId userId,
            String operationDescription, AsyncCallback<Void> cb) {
        proxy.addSuperCls(projectId.getProjectName(), clsName, superClsName, userId.getUserName(), operationDescription, cb);
    }

    public void removeSuperCls(ProjectId projectId, String clsName, String superClsName, UserId userId,
            String operationDescription, AsyncCallback<Void> cb) {
        proxy.removeSuperCls(projectId.getProjectName(), clsName, superClsName, userId.getUserName(), operationDescription, cb);
    }

    public void moveCls(ProjectId projectId, String clsName, String oldParentName, String newParentName, boolean checkForCycles,
            UserId userId, String operationDescription, AsyncCallback<List<EntityData>> cb) {
        proxy.moveCls(projectId.getProjectName(), clsName, oldParentName, newParentName, checkForCycles, userId.getUserName(), operationDescription, cb);
    }

    public void getRestrictionHtml(ProjectId projectId, String className, AsyncCallback<String> cb) {
        proxy.getRestrictionHtml(projectId.getProjectName(), className, cb);
    }

    public void getClassConditions(ProjectId projectId, String className, AsyncCallback<List<ConditionItem>> cb) {
        proxy.getClassConditions(projectId.getProjectName(), className, cb);
    }

    public void deleteCondition(ProjectId projectId, String className, ConditionItem conditionItem, int row, String operationDescription,
            AsyncCallback<List<ConditionItem>> cb) {
        proxy.deleteCondition(projectId.getProjectName(), className, conditionItem, row, operationDescription, cb);
    }

    public  void replaceCondition(ProjectId projectId, String className, ConditionItem conditionItem, int row,
            String newCondition, String operationDescription, AsyncCallback<List<ConditionItem>> callback) {
        proxy.replaceCondition(projectId.getProjectName(), className, conditionItem, row, newCondition, operationDescription, callback);
    }

    public void addCondition(ProjectId projectId, String className, int row, String newCondition, boolean isNS,
            String operationDescription, AsyncCallback<List<ConditionItem>> callback) {
        proxy.addCondition(projectId.getProjectName(), className, row, newCondition, isNS, operationDescription, callback);
    }

    public void getConditionAutocompleteSuggestions(ProjectId projectId, String condition, int cursorPosition,
            AsyncCallback<ConditionSuggestion> callback) {
        proxy.getConditionAutocompleteSuggestions(projectId.getProjectName(), condition, cursorPosition, callback);
    }

    public void getParents(ProjectId projectId, String className, boolean direct, AsyncCallback<List<EntityData>> cb) {
        proxy.getParents(projectId.getProjectName(), className, direct, cb);
    }

    public void getParentsHtml(ProjectId projectId, String className, boolean direct, AsyncCallback<String> cb) {
        proxy.getParentsHtml(projectId.getProjectName(), className, direct, cb);
    }

    public void getRelatedProperties(ProjectId projectId, String className, AsyncCallback<List<Triple>> callback) {
        proxy.getRelatedProperties(projectId.getProjectName(), className, callback);
    }

    /*
     * Properties methods
     */

    public void createObjectProperty(ProjectId projectId, String propertyName, String superPropName, UserId userId,
            String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createObjectProperty(projectId.getProjectName(), propertyName, superPropName, userId.getUserName(), operationDescription, cb);
    }

    public void createDatatypeProperty(ProjectId projectId, String propertyName, String superPropName, UserId userId,
            String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createDatatypeProperty(projectId.getProjectName(), propertyName, superPropName, userId.getUserName(), operationDescription, cb);
    }

    public void createAnnotationProperty(ProjectId projectId, String propertyName, String superPropName, UserId userId,
            String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createAnnotationProperty(projectId.getProjectName(), propertyName, superPropName, userId.getUserName(), operationDescription, cb);
    }

    public void getSubproperties(ProjectId projectId, String propertyName, AsyncCallback<List<EntityData>> cb) {
        proxy.getSubproperties(projectId.getProjectName(), propertyName, cb);
    }

    public void addPropertyValue(ProjectId projectId, String entityName, PropertyEntityData propertyEntity,
            EntityData value, UserId userId, String operationDescription, AsyncCallback<Void> cb) {
        proxy.addPropertyValue(projectId.getProjectName(), entityName, propertyEntity, value, userId.getUserName(), operationDescription, cb);
    }

    public void removePropertyValue(ProjectId projectId, String entityName, PropertyEntityData propertyEntity,
            EntityData value, UserId userId, String operationDescription, AsyncCallback<Void> cb) {
        proxy.removePropertyValue(projectId.getProjectName(), entityName, propertyEntity, value, userId.getUserName(), operationDescription, cb);
    }

    public void replacePropertyValue(ProjectId projectId, String entityName, PropertyEntityData propertyEntity,
            EntityData oldValue, EntityData newValue, UserId userId, String operationDescription, AsyncCallback<Void> cb) {
        proxy.replacePropertyValue(projectId.getProjectName(), entityName, propertyEntity, oldValue, newValue, userId.getUserName(),
                operationDescription, cb);
    }

    public void setPropertyValues(ProjectId projectId, String entityName,  PropertyEntityData propertyEntity,
            List<EntityData> values, UserId userId, String operationDescription, AsyncCallback<Void> cb) {
        proxy.setPropertyValues(projectId.getProjectName(), entityName, propertyEntity, values, userId.getUserName(), operationDescription, cb);
    }

    /*
     * Instance methods
     */

    public void createInstance(ProjectId projectId, String instName, String typeName, UserId userId,
            String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createInstance(projectId.getProjectName(), instName, typeName, userId.getUserName(), operationDescription, cb);
    }

    public void createInstanceValue(ProjectId projectId, String instName, String typeName, String subjectEntity,
            String propertyEntity, UserId userId, String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createInstanceValue(projectId.getProjectName(), instName, typeName, subjectEntity, propertyEntity, userId.getUserName(),
                operationDescription, cb);
    }

    public void createInstanceValueWithPropertyValue(ProjectId projectId, String instName, String typeName,
            String subjectEntity, String propertyEntity, PropertyEntityData instancePropertyEntity,
            EntityData valueEntityData, UserId userId, String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createInstanceValueWithPropertyValue(projectId.getProjectName(), instName, typeName, subjectEntity, propertyEntity,
                instancePropertyEntity, valueEntityData, userId.getUserName(), operationDescription, cb);
    }

    /*
     * Search
     */

    public void search(ProjectId projectId, String searchString, AsyncCallback<List<EntityData>> cb) {
        proxy.search(projectId.getProjectName(), searchString, cb);
    }

    public void search(ProjectId projectId, String searchString, ValueType valueType, AsyncCallback<List<EntityData>> cb) {
        proxy.search(projectId.getProjectName(), searchString, valueType, cb);
    }

    public void search(ProjectId projectId, String searchString, ValueType valueType, int start, int limit, String sort, String dir, AsyncCallback<PaginationData<EntityData>> cb) {
        proxy.search(projectId.getProjectName(), searchString, valueType, start, limit, sort, dir, cb);
    }

    public void getPathToRoot(ProjectId projectId, String entityName, AsyncCallback<List<EntityData>> cb) {
        proxy.getPathToRoot(projectId.getProjectName(), entityName, cb);
    }

    public void getDirectTypes(ProjectId projectId, String instanceName, AsyncCallback<List<EntityData>> cb){
        proxy.getDirectTypes(projectId.getProjectName(), instanceName, cb);
    }

    /*
     * Util methods
     */

    public void getBioPortalSearchContent(ProjectId projectId, String entityName, BioPortalSearchData bpSearchData,
            AsyncCallback<String> cb) {
        proxy.getBioPortalSearchContent(projectId.getProjectName(), entityName, bpSearchData, cb);
    }

    public void getBioPortalSearchContentDetails(ProjectId projectId, BioPortalSearchData bpSearchData,
            BioPortalReferenceData bpRefData, AsyncCallback<String> cb) {
        proxy.getBioPortalSearchContentDetails(projectId.getProjectName(), bpSearchData, bpRefData, cb);
    }

    public void createExternalReference(ProjectId projectId, String entityName, BioPortalReferenceData bpRefData,
            UserId userId, String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.createExternalReference(projectId.getProjectName(), entityName, bpRefData, userId.getUserName(), operationDescription, cb);
    }

    public void replaceExternalReference(ProjectId projectId, String entityName, BioPortalReferenceData bpRefData, EntityData oldValueEntityData,
            UserId userId, String operationDescription, AsyncCallback<EntityData> cb) {
        proxy.replaceExternalReference(projectId.getProjectName(), entityName, bpRefData, oldValueEntityData, userId.getUserName(), operationDescription, cb);
    }


}
