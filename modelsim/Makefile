#
#	Makefile for ModelSim simulation
#


JOPDIR=../vhdl
#OPTIONS=-93 -quiet -check_synthesis -lint -pedanticerrors
OPTIONS=-2008 -quiet

# Mody accordingly to point to the Modelsim Xilix and Altera 
# simulation libraries. Use it for the simulation with the 
# i2c controller. Soon to come i2c without specific primitives.

XIL_VHDL_LIB=
ALT_VHDL_LIB=

ifeq ($(WINDIR),)
	S=:
else
	S=:
endif

# Use Wine on OSX
# I would like to use a better way, but some shell variables
# are not set within make.... Don't know why...
ifeq ($(TERM_PROGRAM),Apple_Terminal)
	WINE=wine
else
	WINE=
endif

all: clean base
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jopcyc.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/tb_jop.vhd
	$(WINE) vsim -do sim.do tb_jop


cmp: clean base
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc_arbiter_pack.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc_arbiter_fair.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/cmpsync.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jopmul.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/tb_jop.vhd
	$(WINE) vsim -do sim_cmp.do tb_jop

# simulation with the i2c controller and an i2c eeprom
iic: clean base
	#vmap simprim $(XIL_VHDL_LIB)/simprim
	#vmap unimacro $(XIL_VHDL_LIB)/unimacro
	#vmap unisim $(XIL_VHDL_LIB)/unisim
	#vmap xilinxcorelib $(XIL_VHDL_LIB)/xilinxcorelib
	#vmap altera_mf $(ALT_VHDL_LIB)/altera_mf
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/led_switch.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/i2c_pkg.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/shift_reg.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/fifo_pkg.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/dual_port_ram.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/read_control.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/write_control.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/synchronizer.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/fifo/async_fifo.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/scl_control.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/sda_control.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/i2c/i2c.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/sc_i2c.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/scio_de2-70_i2c_dual.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jop_iic.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/i2c_eeprom.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/tb_jop_iic.vhd
	$(WINE) vsim -do sim_iic.do tb_jop

# simulation target for the CSP paper project
csp: clean base
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc_arbiter_pack.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc_arbiter_fair.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/cmpsync.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/NoCTypes.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/SimpConSlaveIF.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/SizedFIFOF.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/Receiver.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/Sender.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/TDMANode.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/noc/TDMANoC.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/fifo.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/sc_usb.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/paper/csp/scio_csp.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/paper/csp/jopmulcsp.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/tb_jop.vhd
	$(WINE) vsim -do sim_csp.do tb_jop

base:
	$(WINE) vlib work
	$(WINE) vlib grlib
	$(WINE) vlib gaisler
	$(WINE) vlib techmap
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc_pack.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jop_config_global.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_jop_config_100.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/jop_types.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_ram.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_pll.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_jbc.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_rom.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_memory.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/bytecode.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/microcode.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/sim_sc_uart.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/jtbl.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/cache.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/cache/ocache.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/cache/acache.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/memory/sc_sram32_flash.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/memory/mem_sc.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/memory/sdpram.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/mul.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/bcfetch.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/fetch.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/decode.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/shift.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/stack.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/core.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/sc_sys.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/scio/scio_min.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/core/jopcpu.vhd



clean:
	-rm -rf work
	-rm -rf transcript
	-rm -rf gaisler
	-rm -rf grlib
	-rm -rf techmap
	-rm *.wlf

other_mem:
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/memory/sc_sram16.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jop_256x16.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simulation/tb_jop_sram16.vhd

gaisler:
	$(WINE) vcom -work grlib ../ext/gaisler/version.vhd
	$(WINE) vcom -work grlib ../ext/gaisler/stdlib.vhd
	$(WINE) vcom -work grlib ../ext/gaisler/amba.vhd
	$(WINE) vcom -work gaisler ../ext/gaisler/devices.vhd
	$(WINE) vcom -work techmap ../ext/gaisler/gencomp.vhd
	$(WINE) vcom -work gaisler ../ext/gaisler/memctrl.vhd
	$(WINE) vcom -work gaisler ../ext/gaisler/srctrl.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/simpcon/sc2ahbsl.vhd
	$(WINE) vcom $(OPTIONS) $(JOPDIR)/top/jop_amba.vhd
