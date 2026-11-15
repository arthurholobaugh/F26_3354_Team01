import java.util.HashSet;
import java.util.Set;

public class SharingPermission {
    private String patientId;
    private Set<String> authorizedRecipients;

    public SharingPermission(String patientId) {
        this.patientId = patientId;
        this.authorizedRecipients = new HashSet<>();
    }

    public String getPatientId() {
        return patientId;
    }

    public void grantAccess(String recipientId) {
        if (recipientId != null && !recipientId.trim().isEmpty()) {
            authorizedRecipients.add(recipientId.trim().toLowerCase());
        }
    }

    public void revokeAccess(String recipientId) {
        if (recipientId != null) {
            authorizedRecipients.remove(recipientId.trim().toLowerCase());
        }
    }

    public boolean checkAccess(String recipientId) {
        if (recipientId == null) {
            return false;
        }
        return authorizedRecipients.contains(recipientId.trim().toLowerCase());
    }
}