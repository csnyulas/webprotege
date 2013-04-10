package edu.stanford.bmir.protege.web.server.change;

import edu.stanford.bmir.protege.web.server.owlapi.OWLAPIProject;
import edu.stanford.bmir.protege.web.server.owlapi.RenameMap;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntologyChange;
import org.semanticweb.owlapi.util.OWLEntityRemover;

import java.util.List;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 27/03/2013
 */
public class DeleteEntityChangeListGenerator implements ChangeListGenerator<OWLEntity> {

    private OWLEntity entity;

    public DeleteEntityChangeListGenerator(OWLEntity entity) {
        this.entity = entity;
    }

    @Override
    public GeneratedOntologyChanges<OWLEntity> generateChanges(OWLAPIProject project, ChangeGenerationContext context) {
        GeneratedOntologyChanges.Builder<OWLEntity> builder = new GeneratedOntologyChanges.Builder<OWLEntity>();
        OWLEntityRemover remover = new OWLEntityRemover(project.getRootOntology().getOWLOntologyManager(), project.getRootOntology().getImportsClosure());
        entity.accept(remover);
        List<OWLOntologyChange> changeList = remover.getChanges();
        builder.addAll(changeList);
        return builder.build();
    }

    @Override
    public OWLEntity getRenamedResult(OWLEntity result, RenameMap renameMap) {
        return renameMap.getRenamedEntity(result);
    }
}
