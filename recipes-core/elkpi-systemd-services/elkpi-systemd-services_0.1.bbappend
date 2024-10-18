FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = "\
    file://fpga-config.service \
    file://delia-ui.service \
    file://delia-gui.service \
"

do_install_append () {
    rm -f ${D}${systemd_system_unitdir}/sensei.service
    rm -f ${D}${systemd_system_unitdir}/midi-connections.service
    install -m 0644 ${WORKDIR}/sushi.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/fpga-config.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/delia-ui.service ${D}${systemd_system_unitdir}/
    install -m 0644 ${WORKDIR}/delia-gui.service ${D}${systemd_system_unitdir}/
}

SYSTEMD_SERVICE_${PN} = "\
    sushi.service \
    fpga-config.service \
    delia-ui.service \
    delia-gui.service \
"

# To enable it replace disable with enable.
SYSTEMD_AUTO_ENABLE = "enable"
