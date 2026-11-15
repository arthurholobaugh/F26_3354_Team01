import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SharingPermissionTest {
    private SharingPermission sharingPermission;

    @BeforeEach
    public void setUp() {
        sharingPermission = new SharingPermission("P-101");
    }

    // TC-1: Granting access allows authorized recipients to access data
    @Test
    public void testGrantAccessSuccess() {
        sharingPermission.grantAccess("doctor@clinic.org");
        assertTrue(sharingPermission.checkAccess("doctor@clinic.org"),
            "Authorized recipient should be granted access.");
    }

    // TC-2: Any unauthorized recipients should be blocked
    @Test
    public void testUnauthorizedRecipientBlocked() {
        assertFalse(sharingPermission.checkAccess("unauthorized_user@mail.com"),
            "Unauthorized users must be blocked from accessing glucose records.");
    }

    // TC-3: Revoking access will remove viewing privileges
    @Test
    public void testRevokeAccessRemovesPermission() {
        sharingPermission.grantAccess("caregiver@home.com");
        assertTrue(sharingPermission.checkAccess("caregiver@home.com"));

        sharingPermission.revokeAccess("caregiver@home.com");
        assertFalse(sharingPermission.checkAccess("caregiver@home.com"),
            "Revoked recipient must no longer have access.");
    }
}