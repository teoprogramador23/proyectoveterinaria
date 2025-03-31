package app.controllers;

import app.domain.models.Admin;
import app.domain.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        try {
            adminService.registerAdmin(admin);
            return ResponseEntity.ok("Admin registered successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/approve-medication/{requestId}")
    public ResponseEntity<String> approveMedicationRequest(@PathVariable Long requestId) {
        adminService.approveMedicationRequest(requestId);
        return ResponseEntity.ok("Medication request approved.");
    }

    @PostMapping("/promote-partner/{partnerId}")
    public ResponseEntity<String> promotePartnerToVIP(@PathVariable Long partnerId) {
        adminService.promotePartnerToVIP(partnerId);
        return ResponseEntity.ok("Partner promoted to VIP.");
    }
}
